package com.parkjeongsu.modeler.domain;

public class MenuDefinition {
    private String menuName;
    private Long position;
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