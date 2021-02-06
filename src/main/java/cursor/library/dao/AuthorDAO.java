package cursor.library.dao;

import cursor.library.entities.Author;
import cursor.library.util.HibernateUtil;

import javax.persistence.EntityManager;

public class AuthorDAO {
    public Author getAuthorByID(int id){
        return HibernateUtil.getEntityManager().find(Author.class, id);
    }

    public void createAuthor(Author author){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeAuthor(Author author){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
