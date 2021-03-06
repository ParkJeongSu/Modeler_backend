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
import java.util.ArrayList;
import java.util.HashMap;
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

    public List<ObjectDefinition> getObjectsByObjectName(String objectName) {
        em = emf.createEntityManager();
        String jpql = "SELECT b FROM ObjectDefinition b where 1=1 and b.tableName = '"+ objectName+"' ORDER BY b.position";
        Query query = em.createQuery(jpql);
        List<ObjectDefinition> objectDefinitionList = query.getResultList();
        return objectDefinitionList;
    }
    public List<ObjectDefinition> getObjectsByObjectNameforKey(String objectName) {
        em = emf.createEntityManager();
        String jpql = "SELECT b FROM ObjectDefinition b where 1=1 and b.tableName = '"+ objectName+"' and keyFlag ='Y' ORDER BY b.position";
        Query query = em.createQuery(jpql);
        List<ObjectDefinition> objectDefinitionList = query.getResultList();
        return objectDefinitionList;
    }


    public List<Object> readObjects(String objectName) {
        List<ObjectDefinition> obl = this.getObjectsByObjectName(objectName);
        em = emf.createEntityManager();

        String sql = "SELECT * FROM "+objectName;

        List<Object[]> list = em.createNativeQuery(sql).getResultList();
        List<Object> l= new ArrayList<>();
        for(Object[] ob : list){
            HashMap<String ,Object> map = new HashMap<>();
            for(int i=0;i<ob.length;i++){
                map.put(obl.get(i).getColumnName(),ob[i]);
            }
            l.add(map);
        }

        return l;
    }
    public List<Object[]> deleteObject(String objectName, HashMap<String,Object> map){
        List<ObjectDefinition> obl = this.getObjectsByObjectNameforKey(objectName);
        em = emf.createEntityManager();

        String sql = "SELECT * FROM "+objectName;

        List<Object[]> list = em.createNativeQuery(sql).getResultList();

        return list;
    }

    public List<ObjectDefinition> setObjectInfo(String objectName){
        em = emf.createEntityManager();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("	A.TABLE_NAME , ");
        sb.append("	A.COLUMN_NAME , ");
        sb.append("	A.DATA_TYPE , ");
        sb.append("	A.COLUMN_ID , ");
        sb.append("	NVL2(C.CONSTRAINT_TYPE,'Y','N')  ");
        sb.append("FROM ");
        sb.append("	ALL_TAB_COLUMNS A ");
        sb.append("	LEFT OUTER JOIN ALL_CONS_COLUMNS B ON A.OWNER =B.OWNER AND A.TABLE_NAME =B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ");
        sb.append("	LEFT OUTER JOIN ALL_CONSTRAINTS C ON B.TABLE_NAME = C.TABLE_NAME AND B.CONSTRAINT_NAME =C.CONSTRAINT_NAME AND C.CONSTRAINT_TYPE ='P' ");
        sb.append("WHERE ");
        sb.append("	1=1 ");
        sb.append("	AND A.TABLE_NAME = UPPER ('" + objectName +"') ");
        String jpql = sb.toString();

        List<Object[]> list = em.createNativeQuery(jpql).getResultList();
        List<ObjectDefinition> objectDefinitionList = new ArrayList<>();
        for(Object[] o : list){
            ObjectDefinition objectDefinition = new ObjectDefinition();
            objectDefinition.setTableName(o[0].toString());
            objectDefinition.setColumnName(o[1].toString());
            objectDefinition.setPosition( Long.parseLong(o[3].toString()) );
            objectDefinition.setDataType(o[2].toString());
            objectDefinition.setKeyFlag(o[4].toString());
            this.create(objectDefinition);
            objectDefinitionList.add(objectDefinition);
        }

        return objectDefinitionList;
    }
}
