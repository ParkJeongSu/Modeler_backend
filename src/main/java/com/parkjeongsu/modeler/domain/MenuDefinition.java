package com.parkjeongsu.modeler.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MENUDEFINITION")
public class MenuDefinition implements Serializable {
    @Id
    @Column(name = "MENUNAME")
    private String menuName;

    @Id
    @Column(name = "POSITION")
    private Long position;

    @Id
    @Column(name = "SUPERMENUNAME")
    private String superMenuName;

    public MenuDefinition() {
    }

    public MenuDefinition(String menuName, Long position, String superMenuName) {
        this.menuName = menuName;
        this.position = position;
        this.superMenuName = superMenuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getSuperMenuName() {
        return superMenuName;
    }

    public void setSuperMenuName(String superMenuName) {
        this.superMenuName = superMenuName;
    }
}
