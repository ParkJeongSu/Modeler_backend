package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.MenuDefinition;

import java.util.List;

public interface MenuDefinitionRepository {
    MenuDefinition create(MenuDefinition menuDefinition);
    List<MenuDefinition> readAll();
    // 추후 update
    // 추후 delete
}
