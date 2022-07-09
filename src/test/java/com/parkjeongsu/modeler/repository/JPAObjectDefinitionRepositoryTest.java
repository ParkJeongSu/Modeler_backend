package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.ObjectDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JPAObjectDefinitionRepositoryTest {

    @Autowired
    JPAObjectDefinitionRepository objectDefinitionRepository;

    @Test
    void create() {
        ObjectDefinition objectDefinition = new ObjectDefinition();
        objectDefinition.setTableName("test");
        objectDefinition.setColumnName("test");
        objectDefinition.setPosition(1L);
        objectDefinitionRepository.create(objectDefinition);

        ObjectDefinition objectDefinition2 = new ObjectDefinition();
        objectDefinition2.setTableName("test1");
        objectDefinition2.setColumnName("test1");
        objectDefinition2.setPosition(1L);
        objectDefinitionRepository.create(objectDefinition2);
    }

    @Test
    void readAll() {
        for (ObjectDefinition t : objectDefinitionRepository.readAll()) {
            System.out.println("menuName : " + t.getTableName());
            System.out.println("columnName : " + t.getColumnName());
            System.out.println("position : " + t.getPosition());
        }
    }

    @Test
    void update() {
        ObjectDefinition objectDefinition = new ObjectDefinition();
        objectDefinition.setTableName("test");
        objectDefinition.setColumnName("test");
        objectDefinition.setPosition(1L);
        objectDefinitionRepository.update(objectDefinition);
    }

    @Test
    void delete() {
        ObjectDefinition objectDefinition = new ObjectDefinition();
        objectDefinition.setTableName("test");
        objectDefinition.setColumnName("test");
        objectDefinition.setPosition(1L);
        objectDefinitionRepository.delete(objectDefinition);
    }

    @Test
    void getObjectsByObjectName() {
        List<ObjectDefinition> tList = objectDefinitionRepository.getObjectsByObjectName("MACHINE");
        for (ObjectDefinition t : tList) {
            System.out.println("menuName : " + t.getTableName());
            System.out.println("columnName : " + t.getColumnName());
            System.out.println("position : " + t.getPosition());
        }
    }

    @Test
    void readObjects() {
        List<Object> tList = objectDefinitionRepository.readObjects("MACHINE");
    }
    @Test
    void setObjectInfo() {
        objectDefinitionRepository.setObjectInfo("machine");
    }
}