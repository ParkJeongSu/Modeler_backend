package com.parkjeongsu.modeler.domain.IdClass;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ObjectID implements Serializable {
    @Column(name = "TABLENAME")
    private String tableName;
    @Column(name = "COLUMNNAME")
    private String columnName;
    @Column(name = "POSITION")
    private Long position;

    public ObjectID() {
    }

    public ObjectID(String tableName, String columnName, Long position) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.position = position;
    }
}
