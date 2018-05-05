/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.exec.vector.expressions;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.common.type.HiveChar;
import org.apache.hadoop.hive.common.type.HiveIntervalDayTime;
import org.apache.hadoop.hive.common.type.HiveVarchar;
import org.apache.hadoop.hive.ql.exec.vector.*;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;

/**
 * Constant is represented as a vector with repeating values.
 */
public class ConstantVectorExpression extends VectorExpression {

  private static final long serialVersionUID = 1L;

  private int outputColumn;
  protected long longValue = 0;
  private double doubleValue = 0;
  private byte[] bytesValue = null;
  private HiveDecimal decimalValue = null;
  private Timestamp timestampValue = null;
  private HiveIntervalDayTime intervalDayTimeValue = null;
  private boolean isNullValue = false;

  private final ColumnVector.Type type;
  private int bytesValueLength = 0;

  public ConstantVectorExpression() {
    super();
    // Dummy final assignments.
    type = null;
  }

  ConstantVectorExpression(int outputColumn, TypeInfo outputTypeInfo) {
    this.outputColumn = outputColumn;
    this.outputTypeInfo = outputTypeInfo;
    type = VectorizationContext.getColumnVectorTypeFromTypeInfo(outputTypeInfo);
  }

  public ConstantVectorExpression(int outputColumn, long value, TypeInfo outputTypeInfo) throws
      HiveException {
    this(outputColumn, outputTypeInfo);
    this.longValue = value;
  }

  public ConstantVectorExpression(int outputColumn, double value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    this.doubleValue = value;
  }

  public ConstantVectorExpression(int outputColumn, byte[] value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setBytesValue(value);
  }

  public ConstantVectorExpression(int outputColumn, HiveChar value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setBytesValue(value.getStrippedValue().getBytes());
  }

  public ConstantVectorExpression(int outputColumn, HiveVarchar value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setBytesValue(value.getValue().getBytes());
  }

  // Include type name for precision/scale.
  public ConstantVectorExpression(int outputColumn, HiveDecimal value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setDecimalValue(value);
  }

  public ConstantVectorExpression(int outputColumn, Timestamp value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setTimestampValue(value);
  }

  public ConstantVectorExpression(int outputColumn, HiveIntervalDayTime value, TypeInfo outputTypeInfo) throws HiveException {
    this(outputColumn, outputTypeInfo);
    setIntervalDayTimeValue(value);
  }

  /*
   * Support for null constant object
   */
  public ConstantVectorExpression(int outputColumn, TypeInfo outputTypeInfo, boolean isNull) {
    this(outputColumn, outputTypeInfo);
    isNullValue = isNull;
  }

  /*
   * In the following evaluate* methods, since we are supporting scratch column reuse, we must
   * assume the column may have noNulls of false and some isNull entries true.
   *
   * So, do a proper assignments.
   */

  private void evaluateLong(VectorizedRowBatch vrg) {
    LongColumnVector cv = (LongColumnVector) vrg.cols[outputColumn];

    cv.isRepeating = true;
    if (!isNullValue) {
      cv.isNull[0] = false;
      cv.vector[0] = longValue;
    } else {
      cv.isNull[0] = true;
      cv.noNulls = false;
    }
  }

  private void evaluateDouble(VectorizedRowBatch vrg) {
    DoubleColumnVector cv = (DoubleColumnVector) vrg.cols[outputColumn];
    cv.isRepeating = true;
    if (!isNullValue) {
      cv.isNull[0] = false;
      cv.vector[0] = doubleValue;
    } else {
      cv.isNull[0] = true;
      cv.noNulls = false;
    }
  }

  private void evaluateBytes(VectorizedRowBatch vrg) {
    BytesColumnVector cv = (BytesColumnVector) vrg.cols[outputColumn];
    cv.isRepeating = true;
    cv.initBuffer();
    if (!isNullValue) {
      cv.isNull[0] = false;
      cv.setVal(0, bytesValue, 0, bytesValueLength);
    } else {
      cv.isNull[0] = true;
      cv.noNulls = false;
    }
  }

  private void evaluateDecimal(VectorizedRowBatch vrg) {
    DecimalColumnVector dcv = (DecimalColumnVector) vrg.cols[outputColumn];
    dcv.isRepeating = true;
    if (!isNullValue) {
      dcv.isNull[0] = false;
      dcv.set(0, decimalValue);
    } else {
      dcv.isNull[0] = true;
      dcv.noNulls = false;
    }
  }

  private void evaluateTimestamp(VectorizedRowBatch vrg) {
    TimestampColumnVector tcv = (TimestampColumnVector) vrg.cols[outputColumn];
    tcv.isRepeating = true;
    if (!isNullValue) {
      tcv.isNull[0] = false;
      tcv.set(0, timestampValue);
    } else {
      tcv.isNull[0] = true;
      tcv.noNulls = false;
    }
  }

  private void evaluateIntervalDayTime(VectorizedRowBatch vrg) {
    IntervalDayTimeColumnVector dcv = (IntervalDayTimeColumnVector) vrg.cols[outputColumn];
    dcv.isRepeating = true;
    if (!isNullValue) {
      dcv.isNull[0] = false;
      dcv.set(0, intervalDayTimeValue);
    } else {
      dcv.isNull[0] = true;
      dcv.noNulls = false;
    }
  }

  @Override
  public void evaluate(VectorizedRowBatch vrg) {
    switch (type) {
    case LONG:
      evaluateLong(vrg);
      break;
    case DOUBLE:
      evaluateDouble(vrg);
      break;
    case BYTES:
      evaluateBytes(vrg);
      break;
    case DECIMAL:
      evaluateDecimal(vrg);
      break;
    case TIMESTAMP:
      evaluateTimestamp(vrg);
      break;
    case INTERVAL_DAY_TIME:
      evaluateIntervalDayTime(vrg);
      break;
    }
  }

  @Override
  public int getOutputColumn() {
    return outputColumn;
  }

  public long getLongValue() {
    return longValue;
  }

  public void setLongValue(long longValue) {
    this.longValue = longValue;
  }

  public double getDoubleValue() {
    return doubleValue;
  }

  public void setDoubleValue(double doubleValue) {
    this.doubleValue = doubleValue;
  }

  public byte[] getBytesValue() {
    return bytesValue;
  }

  public void setBytesValue(byte[] bytesValue) {
    this.bytesValue = bytesValue.clone();
    this.bytesValueLength = bytesValue.length;
  }

  public void setDecimalValue(HiveDecimal decimalValue) {
    this.decimalValue = decimalValue;
  }

  public HiveDecimal getDecimalValue() {
    return decimalValue;
  }

  public void setTimestampValue(Timestamp timestampValue) {
    this.timestampValue = timestampValue;
  }

  public Timestamp getTimestampValue() {
    return timestampValue;
  }

  public void setIntervalDayTimeValue(HiveIntervalDayTime intervalDayTimeValue) {
    this.intervalDayTimeValue = intervalDayTimeValue;
  }

  public HiveIntervalDayTime getIntervalDayTimeValue() {
    return intervalDayTimeValue;
  }

  public void setOutputColumn(int outputColumn) {
    this.outputColumn = outputColumn;
  }

  @Override
  public String vectorExpressionParameters() {
    String value;
    if (isNullValue) {
      value = "null";
    } else {
      switch (type) {
      case LONG:
        value = Long.toString(longValue);
        break;
      case DOUBLE:
        value = Double.toString(doubleValue);
        break;
      case BYTES:
        value = new String(bytesValue, StandardCharsets.UTF_8);
        break;
      case DECIMAL:
        value = decimalValue.toString();
        break;
      case TIMESTAMP:
        value = timestampValue.toString();
        break;
      case INTERVAL_DAY_TIME:
        value = intervalDayTimeValue.toString();
        break;
      default:
        throw new RuntimeException("Unknown vector column type " + type);
      }
    }
    return "val " + value;
  }

  @Override
  public VectorExpressionDescriptor.Descriptor getDescriptor() {
    return (new VectorExpressionDescriptor.Builder()).build();
  }
}
