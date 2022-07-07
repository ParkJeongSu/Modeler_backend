package com.parkjeongsu.modeler.domain;

import com.parkjeongsu.modeler.domain.IdClass.MenuID;
import com.parkjeongsu.modeler.domain.IdClass.ObjectID;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ObjectID.class)
@Table(name = "OBJECTDEFINITION")
public class ObjectDefinition implements Serializable {
    @Id
    @Column(name = "TABLENAME")
    private String tableName;
    @Id
    @Column(name = "COLUMNNAME")
    private String columnName;
    @Id
    @Column(name = "POSITION")
    private Long position;

    @Column(name = "KEYFLAG")
    private String keyFlag;

    @Column(name = "USERFLAG")
    private String userFlag;

    @Column(name = "DATEFLAG")
    private String dateFlag;

    @Column(name = "DATATYPE")
    private String dataType;

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

    public String getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(String keyFlag) {
        this.keyFlag = keyFlag;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getDateFlag() {
        return dateFlag;
    }

    public void setDateFlag(String dateFlag) {
        this.dateFlag = dateFlag;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
