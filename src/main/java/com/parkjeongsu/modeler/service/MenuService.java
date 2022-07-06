package com.parkjeongsu.modeler.service;

import com.parkjeongsu.modeler.domain.MenuDefinition;
import com.parkjeongsu.modeler.repository.MenuDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDefinitionRepository menuDefinitionRepository;

    public MenuDefinition addMenu(MenuDefinition menuDefinition){
        return menuDefinitionRepository.create(menuDefinition);
    }

    public List<MenuDefinition> getMenu(){
        return menuDefinitionRepository.readAll();
    }
}
