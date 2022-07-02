package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.ObjectDefinition;

import java.util.List;

public interface ObjectDefinitionRepository {
    ObjectDefinition create(ObjectDefinition objectDefinition);
    List<ObjectDefinition> readAll();
    // 추후 update
    // 추후 delete
}
