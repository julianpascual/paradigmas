package ar.edu.uai.paradigms.dao;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Created by Federico on 19/10/2014.
 */
public interface PersistentDAO<ENTITY, IDENTIFIER, CRITERIA> {
    public ENTITY create(ENTITY entity);
    public ENTITY retrieve(IDENTIFIER id);
    public ENTITY update(ENTITY entity);
    public void delete(IDENTIFIER id);
    public List<ENTITY> retrieveByCriteria(CRITERIA criteria);
    public List<ENTITY> getSons(IDENTIFIER id);
}
