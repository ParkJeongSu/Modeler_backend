package com.parkjeongsu.modeler.domain;

public class ObjectDefinition {
    private String tableName;
    private String columnName;
    private Long position;

    public ObjectDefinition() {
    }

    public ObjectDefinition(String tableName, String columnName, Long position) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.position = position;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
