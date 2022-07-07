package com.parkjeongsu.modeler.controller;

import com.parkjeongsu.modeler.domain.UserDefinition;
import com.parkjeongsu.modeler.service.MenuService;
import com.parkjeongsu.modeler.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class ObjectDefinitionController {
    @Autowired
    private ObjectService objectService;

    @GetMapping("objects/{objectName}")
    @ResponseBody
    public HashMap<String,Object> getObjects(@PathVariable("objectName") String objectName){
        HashMap<String,Object> map =new HashMap<>();
        List<Object> objList = objectService.getObjects(objectName);
        map.put("objects",objList);
        return map;
    }

    @DeleteMapping("objects/{objectName}")
    @ResponseBody
    public HashMap<String,Object> removeObjects(@PathVariable("objectName") String objectName, @RequestBody HashMap<String,Object> map){

        System.out.println(objectName);
        System.out.println(map);
        return map;
    }


}
