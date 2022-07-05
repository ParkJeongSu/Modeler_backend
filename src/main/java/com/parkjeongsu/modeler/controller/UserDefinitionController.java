package com.parkjeongsu.modeler.controller;

import com.parkjeongsu.modeler.domain.UserDefinition;
import com.parkjeongsu.modeler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Controller
public class UserDefinitionController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public HashMap<String,Object> login(@RequestBody HashMap<String,Object> map){
        String userId = map.get("userId").toString();
        String password = map.get("password").toString();
        boolean login = userService.login(userId,password);
        UserDefinition userDefinition = userService.getUserDefinition(userId);
        HashMap<String,Object> r = new HashMap<String,Object>();
        r.put("login",login);
        r.put("user",userDefinition);
        return r;
    }
}
