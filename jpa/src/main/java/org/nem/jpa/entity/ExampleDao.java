package org.nem.jpa.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExampleDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    
    public Example create(Example example){
        this.entityManager.persist(example);
        return example;
    }
    
    public Example update(Example example){
        Example existing = this.find(example.getId());
        existing.setTitle(example.getTitle());
        return existing;
    }
    
    public void delete(Example example){
        this.entityManager.remove(example);
    }
    
    public Example find(Integer id){
        return this.entityManager.find(Example.class, id);
    }

}
