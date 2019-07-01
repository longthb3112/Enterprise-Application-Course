package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("Lab7");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // LazyCollection = 20794 ,19857, 20231
        // fastest on my computer : Batch(size = 10) = 18401, 18881 | Batch(size = 3) = 22398 | Batch(size = 50) = 15840
        // Fetch(FetchMode = SUBSELECT) = 19193, 21072
        // NamedQuery =  19508, 18701
        // EntityGraph = 18295, 18635

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        //Join fetch
        // TypedQuery<Owner> query = em.createQuery("select o from Owner o Join Fetch o.pets", Owner.class);

        //Named query
        //TypedQuery<Owner> query = em.createNamedQuery("Owner.pets",Owner.class);

        //Entity Graph
      //EntityGraph<Owner> entityGraph = em.createEntityGraph(Owner.class);
      // entityGraph.addSubgraph("pets");
       //query.setHint("javax.persistence.fetchgraph",entityGraph);

        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
