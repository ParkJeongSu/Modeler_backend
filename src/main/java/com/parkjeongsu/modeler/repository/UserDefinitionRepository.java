package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.UserDefinition;

import java.util.List;

public interface UserDefinitionRepository {
    UserDefinition create(UserDefinition menuDefinition);
    UserDefinition read(String userId);
    List<UserDefinition> readAll();
    // 추후 update
    // 추후 delete
}
