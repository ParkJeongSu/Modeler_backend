package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.UserDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class JPAUserDefinitionRepository implements UserDefinitionRepository{

    @Autowired
    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public UserDefinition create(UserDefinition userDefinition) {
        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try{
                em.persist(userDefinition);

                tx.commit();
            }
            catch (Exception e){
                tx.rollback();
                System.out.println(e.getMessage());
            }
            finally {
                em.clear();
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userDefinition;
    }

    @Override
    public List<UserDefinition> readAll() {
        return null;
    }

    @Override
    public UserDefinition read(String userId) {
        em = emf.createEntityManager();
        UserDefinition userDefinition = em.find(UserDefinition.class,userId);
        return userDefinition;
    }
}
