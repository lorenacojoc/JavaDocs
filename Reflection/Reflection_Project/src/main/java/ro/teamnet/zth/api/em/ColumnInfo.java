package ro.teamnet.zth.api.em;

import java.util.Objects;

/**
 * Created by Lorena on 7/7/2016.
 */
public class ColumnInfo {
    private String columnName;
    private Class getColumnType;
    private String dbName;
    private boolean isId;
    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getGetColumnType() {
        return getColumnType;
    }

    public void setGetColumnType(Class getColumnType) {
        this.getColumnType = getColumnType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }




}
