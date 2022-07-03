package com.parkjeongsu.modeler.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ObjectDefinition")
public class ObjectDefinition implements Serializable {
    @Id
    private String tableName;
    @Id
    private String columnName;
    @Id
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
