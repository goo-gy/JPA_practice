package practice.repository;

import practice.domain.Gender;
import practice.domain.Member;

import javax.persistence.*;

public class MemberRepository {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    public void persistContext() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 비영속
            Member member = new Member();
            member.setName("letters!");

            // 영속
            System.out.println("----------------- BEFORE SAVE");
            em.persist(member);
            System.out.println("----------------- AFTER SAVE");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Error: " + e);
        } finally {
            em.close();
        }
    }

    public void testIdentity() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
//            member.setId(10L);
            member.setName("abcd");
            System.out.println("----------------- BEFORE SAVE");
            em.persist(member);
            System.out.println("ID: " + member.getId());
            System.out.println("----------------- AFTER SAVE");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Error: " + e);
        } finally {
            em.close();
        }
    }

    public void testAllocationSize() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();
            member1.setName("abcd");
            member2.setName("abcd");
            member3.setName("abcd");
            System.out.println("----------------- BEFORE SAVE");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("ID: " + member1.getId());
            System.out.println("ID: " + member2.getId());
            System.out.println("ID: " + member3.getId());
            System.out.println("----------------- AFTER SAVE");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Error: " + e);
        } finally {
            em.close();
        }
    }
}
