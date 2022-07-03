package com.parkjeongsu.modeler.controller;

import com.parkjeongsu.modeler.domain.MenuDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuDefinitionController {

    @GetMapping("users")
    @ResponseBody
    public List<MenuDefinition> getUser(){
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

}
