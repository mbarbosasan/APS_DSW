package dao;

import entities.Planeta;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class PlanetaDAO {

    public static void save(Planeta planeta) {
        EntityManager entityManager = JPAUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(planeta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Planeta> listAll() {
        EntityManager entityManager = JPAUtil.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT p FROM Planeta p order by p.idGalactico");
        List<Planeta> lista = query.getResultList();
        entityManager.close();
        return lista;
    }

    public static void delete(Planeta planeta) {
        EntityManager entityManager = JPAUtil.createEntityManager();
        entityManager.getTransaction().begin();
        planeta = entityManager.find(Planeta.class, planeta.getIdGalactico());
        entityManager.remove(planeta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
