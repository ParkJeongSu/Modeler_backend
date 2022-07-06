package com.parkjeongsu.modeler.repository;

import com.parkjeongsu.modeler.domain.IdClass.ObjectID;
import com.parkjeongsu.modeler.domain.MenuDefinition;
import com.parkjeongsu.modeler.domain.ObjectDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@Repository
public class JPAObjectDefinitionRepository implements ObjectDefinitionRepository{
    @Autowired
    private EntityManagerFactory emf;

    private EntityManager em;

    @Override
    public ObjectDefinition create(ObjectDefinition objectDefinition) {
        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try{
                em.persist(objectDefinition);
                System.out.println("menuName : " + objectDefinition.getTableName());
                System.out.println("columnName : " + objectDefinition.getColumnName());
                System.out.println("position : " + objectDefinition.getPosition());

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

        return objectDefinition;
    }

    @Override
    public List<ObjectDefinition> readAll() {
        em = emf.createEntityManager();
        String jpql = "SELECT b FROM ObjectDefinition b ";
        Query query = em.createQuery(jpql);
        List<ObjectDefinition> objectDefinitionList = query.getResultList();
        return objectDefinitionList;
    }

    @Override
    public ObjectDefinition update(ObjectDefinition oldObjectDefinition) {
        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try{
                ObjectDefinition newObjectDefinition = em.find(ObjectDefinition.class, new ObjectID(oldObjectDefinition.getTableName(),oldObjectDefinition.getColumnName(),oldObjectDefinition.getPosition()));
                newObjectDefinition.setUserFlag("Y");
                newObjectDefinition.setDateFlag("Y");
                newObjectDefinition.setDataType("varchar2");
                em.persist(newObjectDefinition);
                tx.commit();
                return newObjectDefinition;
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

        return oldObjectDefinition;
    }

    @Override
    public boolean delete(ObjectDefinition objectDefinition) {

        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try{
                ObjectDefinition findObject = em.find(ObjectDefinition.class,new ObjectID(objectDefinition.getTableName(),objectDefinition.getColumnName(),objectDefinition.getPosition()));
                em.remove(findObject);
                tx.commit();
                return true;
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

        return false;
    }
}