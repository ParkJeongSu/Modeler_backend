package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.ObjectDefinition;

import java.util.List;

public interface ObjectDefinitionRepository {
    ObjectDefinition create(ObjectDefinition objectDefinition);
    List<ObjectDefinition> readAll();
    ObjectDefinition update(ObjectDefinition objectDefinition);
    boolean delete(ObjectDefinition objectDefinition);
}
