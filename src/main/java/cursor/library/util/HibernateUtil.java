package cursor.library.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryDB");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
