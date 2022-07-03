package com.parkjeongsu.modeler.controller;

import com.parkjeongsu.modeler.domain.MenuDefinition;
import com.parkjeongsu.modeler.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuDefinitionController {
    @Autowired
    private MenuService menuService;

    @GetMapping("users")
    @ResponseBody
    public List<MenuDefinition> getMenu(){
        List<MenuDefinition> menuDefinitionList = new ArrayList<>();

        MenuDefinition menuDefinition1 = new MenuDefinition();
        menuDefinition1.setMenuName("test1");
        menuDefinition1.setPosition(1L);
        menuDefinition1.setSuperMenuName("test");

        MenuDefinition menuDefinition2 = new MenuDefinition();
        menuDefinition2.setMenuName("test2");
        menuDefinition2.setPosition(1L);
        menuDefinition2.setSuperMenuName("test2");

        menuDefinitionList.add(menuDefinition1);
        menuDefinitionList.add(menuDefinition2);

        return menuDefinitionList;
    }

    @PostMapping("menus")
    @ResponseBody
    public List<MenuDefinition> addMenu(){
        List<MenuDefinition> menuDefinitionList = new ArrayList<>();

        MenuDefinition menuDefinition1 = new MenuDefinition();
        menuDefinition1.setMenuName("test1");
        menuDefinition1.setPosition(1L);
        menuDefinition1.setSuperMenuName("test");

        MenuDefinition menuDefinition2 = new MenuDefinition();
        menuDefinition2.setMenuName("test2");
        menuDefinition2.setPosition(1L);
        menuDefinition2.setSuperMenuName("test2");

        menuDefinitionList.add(menuDefinition1);
        menuDefinitionList.add(menuDefinition2);

        menuService.addMenu(menuDefinition1);

        return menuDefinitionList;
    }

}
