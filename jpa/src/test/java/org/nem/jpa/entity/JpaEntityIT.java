package org.nem.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author nemanja
 */
public class JpaEntityIT {

    EntityManager entityManager;
    EntityTransaction entityTransaction;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void initEM() {
        this.entityManager = Persistence.createEntityManagerFactory("org.nem.jpa.itpu").createEntityManager();
        this.entityTransaction = this.entityManager.getTransaction();
    }

    @Test
    public void persistTest() {

        this.entityTransaction.begin();
        JpaTestEntity find1 = this.entityManager.find(JpaTestEntity.class, 1);
        this.entityTransaction.commit();
        Assert.assertNull(find1);

        JpaTestEntity jpaTestEntity = new JpaTestEntity();
        jpaTestEntity.setId(1);
        jpaTestEntity.setTitle("testper");
        this.entityTransaction.begin();
        this.entityManager.persist(jpaTestEntity);
        this.entityTransaction.commit();

        this.entityTransaction.begin();
        JpaTestEntity find2 = this.entityManager.find(JpaTestEntity.class, 1);
        this.entityTransaction.commit();
        Assert.assertNotNull(find2);
    }

    @Test(expected = OptimisticLockException.class)
    public void versionTest() {
        JpaTestEntity jpaTestEntity = new JpaTestEntity();
        jpaTestEntity.setId(2);
        jpaTestEntity.setTitle("testver");

        this.entityTransaction.begin();
        this.entityManager.persist(jpaTestEntity);
        this.entityTransaction.commit();

        this.entityTransaction.begin();
        JpaTestEntity find1 = this.entityManager.find(JpaTestEntity.class, 2);
        this.entityManager.detach(find1);
        this.entityTransaction.commit();

        this.entityTransaction.begin();
        JpaTestEntity find2 = this.entityManager.find(JpaTestEntity.class, 2);
        this.entityManager.detach(find2);
        this.entityTransaction.commit();

        this.entityTransaction.begin();
        find1.setTitle("fchange");
        this.entityManager.merge(find1);
        this.entityTransaction.commit();

        this.entityTransaction.begin();
        find2.setTitle("schange");
        this.entityManager.merge(find2);
        this.entityTransaction.commit();

    }
}
