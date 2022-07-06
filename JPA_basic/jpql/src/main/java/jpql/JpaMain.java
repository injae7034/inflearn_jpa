package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUserName("member1");
            member.setAge(10);
            em.persist(member);

            TypedQuery<Member> memberTypedQuery =
                    em.createQuery("select m from Member m", Member.class);
            TypedQuery<String> stringTypedQuery =
                    em.createQuery("select m.username from Member m", String.class);
            Query query = em.createQuery("select m.username, m.age from Member m");

            TypedQuery<Member> query1 =
                    em.createQuery("select m from Member m where m.username = :username", Member.class);
            query1.setParameter("username", "member1");
            Member singleResult = query1.getSingleResult();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
