package com.parkjeongsu.modeler.domain.IdClass;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MenuID implements Serializable {
    @Column(name = "MENUNAME")
    private String menuName;

    @Column(name = "POSITION")
    private Long position;

    @Column(name = "SUPERMENUNAME")
    private String superMenuName;

    public MenuID() {
    }

    public MenuID(String menuName, Long position, String superMenuName) {
        this.menuName = menuName;
        this.position = position;
        this.superMenuName = superMenuName;
    }
}
