package cursor.library.dao;

import cursor.library.entities.Book;
import cursor.library.entities.User;
import cursor.library.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAO {

    public Book getBookByID(int id){
        return HibernateUtil.getEntityManager().find(Book.class, id);
    }

    public void createBook(Book book){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateBook(Book book){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeBook(Book book){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Book> getAllBooks(){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery("From Book").getResultList();
    }

}
