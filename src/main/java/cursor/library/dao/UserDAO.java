package cursor.library.dao;

import cursor.library.entities.Book;
import cursor.library.entities.User;
import cursor.library.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {

    public User getUserByID(int id){
        return HibernateUtil.getEntityManager().find(User.class, id);
    }

    public void createUser(User user){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateUser(User user){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeUserById(int id){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, 1);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers(){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        List<User> users = entityManager.createQuery("From User").getResultList();
        return users;
    }

    public List<Book> getBooksByUserId(int id){
        User user = getUserByID(id);
        return user.getBooks();
    }
}
