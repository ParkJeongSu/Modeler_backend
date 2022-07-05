package com.parkjeongsu.modeler.service;

import com.parkjeongsu.modeler.domain.UserDefinition;
import com.parkjeongsu.modeler.repository.UserDefinitionRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDefinitionRepository userDefinitionRepository;

    public Boolean login(String userId, String password){
        UserDefinition userDefinition = null;
        userDefinition = userDefinitionRepository.read(userId);
        if (userDefinition!=null){
            if(userDefinition.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public UserDefinition getUserDefinition(String userId){
        return userDefinitionRepository.read(userId);
    }
}
