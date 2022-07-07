package com.parkjeongsu.modeler.service;

import com.parkjeongsu.modeler.domain.MenuDefinition;
import com.parkjeongsu.modeler.domain.ObjectDefinition;
import com.parkjeongsu.modeler.repository.JPAObjectDefinitionRepository;
import com.parkjeongsu.modeler.repository.ObjectDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService {

    @Autowired
    private JPAObjectDefinitionRepository jpaObjectDefinitionRepository;

    public List<Object> getObjects(String objectName){
        return jpaObjectDefinitionRepository.readObjects(objectName);
    }


}
