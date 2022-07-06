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

    @GetMapping("menus")
    @ResponseBody
    public List<MenuDefinition> getMenu(){
        List<MenuDefinition> menuDefinitionList = menuService.getMenu();

        return menuDefinitionList;
    }

}
