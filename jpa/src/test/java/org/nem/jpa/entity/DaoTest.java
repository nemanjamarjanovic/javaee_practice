package org.nem.jpa.entity;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Test;

public class DaoTest {
    
    @Test
     public void test() throws Exception {

        final Context context = EJBContainer.createEJBContainer().getContext();
        ExampleDao dao = (ExampleDao) context.lookup("java:global/jpa/ExampleDao");

    Example e = new Example();
    e.setId(1);
    e.setTitle("First");
    e = dao.create(e);
        //dao.find();
    System.out.println(e);
    }
}
