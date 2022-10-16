package practice.repository;

import practice.domain.Gender;
import practice.domain.Member;

import javax.persistence.*;
import java.util.List;

public class MemberRepository {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    public void persistContext() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 비영속
            Member member = new Member();
            member.setId(4L);
            member.setName("fucking10letters!");

            // 영속
            System.out.println("----------------- BEFORE SAVE");
            em.persist(member);
            System.out.println("----------------- AFTER SAVE");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void entitySame() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member findMember1 = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);

            System.out.println(findMember1 == findMember1);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void batchFlush() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member1 = new Member(5L, "A");
            Member member2 = new Member(6L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("=========================");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();
    }

    public void detectChange() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = em.find(Member.class, 3L);
            em.persist(member);
            member.setName("Changed");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();
    }

    public void delete() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = em.find(Member.class, 6L);
            em.remove(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();
    }

    public void testFlush() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member(201L, "member201");
            em.persist(member);
//            em.flush();

            System.out.println("=======================");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();
    }

    public void testDetach() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = em.find(Member.class, 1L);
            member.setName("Modify");
            em.detach(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();

    }

    public void testMapping() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member(201L, "member201", Gender.MALE);
            em.persist(member);
            System.out.println("=======================");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
        emf.close();
    }
}
