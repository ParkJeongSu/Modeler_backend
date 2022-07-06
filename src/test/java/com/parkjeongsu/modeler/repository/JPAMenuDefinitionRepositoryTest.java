package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.MenuDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JPAMenuDefinitionRepositoryTest {

    @Autowired
    private MenuDefinitionRepository menuDefinitionRepository;

    @Test
    void readAll() {
        List<MenuDefinition> menuDefinitionList = menuDefinitionRepository.readAll();
        for (MenuDefinition m : menuDefinitionList) {
            System.out.println("menuName : " + m.getMenuName() + " position " + m.getPosition() );
        }
    }
}