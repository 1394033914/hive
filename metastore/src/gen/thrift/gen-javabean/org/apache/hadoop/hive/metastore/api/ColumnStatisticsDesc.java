/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
@org.apache.hadoop.hive.common.classification.InterfaceAudience.Public @org.apache.hadoop.hive.common.classification.InterfaceStability.Stable public class ColumnStatisticsDesc implements org.apache.thrift.TBase<ColumnStatisticsDesc, ColumnStatisticsDesc._Fields>, java.io.Serializable, Cloneable, Comparable<ColumnStatisticsDesc> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ColumnStatisticsDesc");

  private static final org.apache.thrift.protocol.TField IS_TBL_LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("isTblLevel", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PART_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("partName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_ANALYZED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastAnalyzed", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ColumnStatisticsDescStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ColumnStatisticsDescTupleSchemeFactory());
  }

  private boolean isTblLevel; // required
  private String dbName; // required
  private String tableName; // required
  private String partName; // optional
  private long lastAnalyzed; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    IS_TBL_LEVEL((short)1, "isTblLevel"),
    DB_NAME((short)2, "dbName"),
    TABLE_NAME((short)3, "tableName"),
    PART_NAME((short)4, "partName"),
    LAST_ANALYZED((short)5, "lastAnalyzed");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // IS_TBL_LEVEL
          return IS_TBL_LEVEL;
        case 2: // DB_NAME
          return DB_NAME;
        case 3: // TABLE_NAME
          return TABLE_NAME;
        case 4: // PART_NAME
          return PART_NAME;
        case 5: // LAST_ANALYZED
          return LAST_ANALYZED;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ISTBLLEVEL_ISSET_ID = 0;
  private static final int __LASTANALYZED_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PART_NAME,_Fields.LAST_ANALYZED};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IS_TBL_LEVEL, new org.apache.thrift.meta_data.FieldMetaData("isTblLevel", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PART_NAME, new org.apache.thrift.meta_data.FieldMetaData("partName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAST_ANALYZED, new org.apache.thrift.meta_data.FieldMetaData("lastAnalyzed", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ColumnStatisticsDesc.class, metaDataMap);
  }

  public ColumnStatisticsDesc() {
  }

  public ColumnStatisticsDesc(
    boolean isTblLevel,
    String dbName,
    String tableName)
  {
    this();
    this.isTblLevel = isTblLevel;
    setIsTblLevelIsSet(true);
    this.dbName = org.apache.hive.common.util.HiveStringUtils.intern(dbName);
    this.tableName = org.apache.hive.common.util.HiveStringUtils.intern(tableName);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ColumnStatisticsDesc(ColumnStatisticsDesc other) {
    __isset_bitfield = other.__isset_bitfield;
    this.isTblLevel = other.isTblLevel;
    if (other.isSetDbName()) {
      this.dbName = org.apache.hive.common.util.HiveStringUtils.intern(other.dbName);
    }
    if (other.isSetTableName()) {
      this.tableName = org.apache.hive.common.util.HiveStringUtils.intern(other.tableName);
    }
    if (other.isSetPartName()) {
      this.partName = other.partName;
    }
    this.lastAnalyzed = other.lastAnalyzed;
  }

  public ColumnStatisticsDesc deepCopy() {
    return new ColumnStatisticsDesc(this);
  }

  @Override
  public void clear() {
    setIsTblLevelIsSet(false);
    this.isTblLevel = false;
    this.dbName = null;
    this.tableName = null;
    this.partName = null;
    setLastAnalyzedIsSet(false);
    this.lastAnalyzed = 0;
  }

  public boolean isIsTblLevel() {
    return this.isTblLevel;
  }

  public void setIsTblLevel(boolean isTblLevel) {
    this.isTblLevel = isTblLevel;
    setIsTblLevelIsSet(true);
  }

  public void unsetIsTblLevel() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISTBLLEVEL_ISSET_ID);
  }

  /** Returns true if field isTblLevel is set (has been assigned a value) and false otherwise */
  public boolean isSetIsTblLevel() {
    return EncodingUtils.testBit(__isset_bitfield, __ISTBLLEVEL_ISSET_ID);
  }

  public void setIsTblLevelIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISTBLLEVEL_ISSET_ID, value);
  }

  public String getDbName() {
    return this.dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = org.apache.hive.common.util.HiveStringUtils.intern(dbName);
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = org.apache.hive.common.util.HiveStringUtils.intern(tableName);
  }

  public void unsetTableName() {
    this.tableName = null;
  }

  /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
  public boolean isSetTableName() {
    return this.tableName != null;
  }

  public void setTableNameIsSet(boolean value) {
    if (!value) {
      this.tableName = null;
    }
  }

  public String getPartName() {
    return this.partName;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }

  public void unsetPartName() {
    this.partName = null;
  }

  /** Returns true if field partName is set (has been assigned a value) and false otherwise */
  public boolean isSetPartName() {
    return this.partName != null;
  }

  public void setPartNameIsSet(boolean value) {
    if (!value) {
      this.partName = null;
    }
  }

  public long getLastAnalyzed() {
    return this.lastAnalyzed;
  }

  public void setLastAnalyzed(long lastAnalyzed) {
    this.lastAnalyzed = lastAnalyzed;
    setLastAnalyzedIsSet(true);
  }

  public void unsetLastAnalyzed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTANALYZED_ISSET_ID);
  }

  /** Returns true if field lastAnalyzed is set (has been assigned a value) and false otherwise */
  public boolean isSetLastAnalyzed() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTANALYZED_ISSET_ID);
  }

  public void setLastAnalyzedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTANALYZED_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case IS_TBL_LEVEL:
      if (value == null) {
        unsetIsTblLevel();
      } else {
        setIsTblLevel((Boolean)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((String)value);
      }
      break;

    case TABLE_NAME:
      if (value == null) {
        unsetTableName();
      } else {
        setTableName((String)value);
      }
      break;

    case PART_NAME:
      if (value == null) {
        unsetPartName();
      } else {
        setPartName((String)value);
      }
      break;

    case LAST_ANALYZED:
      if (value == null) {
        unsetLastAnalyzed();
      } else {
        setLastAnalyzed((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case IS_TBL_LEVEL:
      return isIsTblLevel();

    case DB_NAME:
      return getDbName();

    case TABLE_NAME:
      return getTableName();

    case PART_NAME:
      return getPartName();

    case LAST_ANALYZED:
      return getLastAnalyzed();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case IS_TBL_LEVEL:
      return isSetIsTblLevel();
    case DB_NAME:
      return isSetDbName();
    case TABLE_NAME:
      return isSetTableName();
    case PART_NAME:
      return isSetPartName();
    case LAST_ANALYZED:
      return isSetLastAnalyzed();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ColumnStatisticsDesc)
      return this.equals((ColumnStatisticsDesc)that);
    return false;
  }

  public boolean equals(ColumnStatisticsDesc that) {
    if (that == null)
      return false;

    boolean this_present_isTblLevel = true;
    boolean that_present_isTblLevel = true;
    if (this_present_isTblLevel || that_present_isTblLevel) {
      if (!(this_present_isTblLevel && that_present_isTblLevel))
        return false;
      if (this.isTblLevel != that.isTblLevel)
        return false;
    }

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_tableName = true && this.isSetTableName();
    boolean that_present_tableName = true && that.isSetTableName();
    if (this_present_tableName || that_present_tableName) {
      if (!(this_present_tableName && that_present_tableName))
        return false;
      if (!this.tableName.equals(that.tableName))
        return false;
    }

    boolean this_present_partName = true && this.isSetPartName();
    boolean that_present_partName = true && that.isSetPartName();
    if (this_present_partName || that_present_partName) {
      if (!(this_present_partName && that_present_partName))
        return false;
      if (!this.partName.equals(that.partName))
        return false;
    }

    boolean this_present_lastAnalyzed = true && this.isSetLastAnalyzed();
    boolean that_present_lastAnalyzed = true && that.isSetLastAnalyzed();
    if (this_present_lastAnalyzed || that_present_lastAnalyzed) {
      if (!(this_present_lastAnalyzed && that_present_lastAnalyzed))
        return false;
      if (this.lastAnalyzed != that.lastAnalyzed)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_isTblLevel = true;
    list.add(present_isTblLevel);
    if (present_isTblLevel)
      list.add(isTblLevel);

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_tableName = true && (isSetTableName());
    list.add(present_tableName);
    if (present_tableName)
      list.add(tableName);

    boolean present_partName = true && (isSetPartName());
    list.add(present_partName);
    if (present_partName)
      list.add(partName);

    boolean present_lastAnalyzed = true && (isSetLastAnalyzed());
    list.add(present_lastAnalyzed);
    if (present_lastAnalyzed)
      list.add(lastAnalyzed);

    return list.hashCode();
  }

  @Override
  public int compareTo(ColumnStatisticsDesc other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIsTblLevel()).compareTo(other.isSetIsTblLevel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsTblLevel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isTblLevel, other.isTblLevel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbName()).compareTo(other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTableName()).compareTo(other.isSetTableName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTableName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartName()).compareTo(other.isSetPartName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partName, other.partName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastAnalyzed()).compareTo(other.isSetLastAnalyzed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastAnalyzed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastAnalyzed, other.lastAnalyzed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ColumnStatisticsDesc(");
    boolean first = true;

    sb.append("isTblLevel:");
    sb.append(this.isTblLevel);
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tableName:");
    if (this.tableName == null) {
      sb.append("null");
    } else {
      sb.append(this.tableName);
    }
    first = false;
    if (isSetPartName()) {
      if (!first) sb.append(", ");
      sb.append("partName:");
      if (this.partName == null) {
        sb.append("null");
      } else {
        sb.append(this.partName);
      }
      first = false;
    }
    if (isSetLastAnalyzed()) {
      if (!first) sb.append(", ");
      sb.append("lastAnalyzed:");
      sb.append(this.lastAnalyzed);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetIsTblLevel()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'isTblLevel' is unset! Struct:" + toString());
    }

    if (!isSetDbName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' is unset! Struct:" + toString());
    }

    if (!isSetTableName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tableName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ColumnStatisticsDescStandardSchemeFactory implements SchemeFactory {
    public ColumnStatisticsDescStandardScheme getScheme() {
      return new ColumnStatisticsDescStandardScheme();
    }
  }

  private static class ColumnStatisticsDescStandardScheme extends StandardScheme<ColumnStatisticsDesc> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ColumnStatisticsDesc struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // IS_TBL_LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isTblLevel = iprot.readBool();
              struct.setIsTblLevelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = org.apache.hive.common.util.HiveStringUtils.intern(iprot.readString());
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tableName = org.apache.hive.common.util.HiveStringUtils.intern(iprot.readString());
              struct.setTableNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PART_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.partName = iprot.readString();
              struct.setPartNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LAST_ANALYZED
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lastAnalyzed = iprot.readI64();
              struct.setLastAnalyzedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ColumnStatisticsDesc struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(IS_TBL_LEVEL_FIELD_DESC);
      oprot.writeBool(struct.isTblLevel);
      oprot.writeFieldEnd();
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.tableName != null) {
        oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
        oprot.writeString(struct.tableName);
        oprot.writeFieldEnd();
      }
      if (struct.partName != null) {
        if (struct.isSetPartName()) {
          oprot.writeFieldBegin(PART_NAME_FIELD_DESC);
          oprot.writeString(struct.partName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLastAnalyzed()) {
        oprot.writeFieldBegin(LAST_ANALYZED_FIELD_DESC);
        oprot.writeI64(struct.lastAnalyzed);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ColumnStatisticsDescTupleSchemeFactory implements SchemeFactory {
    public ColumnStatisticsDescTupleScheme getScheme() {
      return new ColumnStatisticsDescTupleScheme();
    }
  }

  private static class ColumnStatisticsDescTupleScheme extends TupleScheme<ColumnStatisticsDesc> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ColumnStatisticsDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeBool(struct.isTblLevel);
      oprot.writeString(struct.dbName);
      oprot.writeString(struct.tableName);
      BitSet optionals = new BitSet();
      if (struct.isSetPartName()) {
        optionals.set(0);
      }
      if (struct.isSetLastAnalyzed()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPartName()) {
        oprot.writeString(struct.partName);
      }
      if (struct.isSetLastAnalyzed()) {
        oprot.writeI64(struct.lastAnalyzed);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ColumnStatisticsDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.isTblLevel = iprot.readBool();
      struct.setIsTblLevelIsSet(true);
      struct.dbName = org.apache.hive.common.util.HiveStringUtils.intern(iprot.readString());
      struct.setDbNameIsSet(true);
      struct.tableName = org.apache.hive.common.util.HiveStringUtils.intern(iprot.readString());
      struct.setTableNameIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.partName = iprot.readString();
        struct.setPartNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.lastAnalyzed = iprot.readI64();
        struct.setLastAnalyzedIsSet(true);
      }
    }
  }

}

