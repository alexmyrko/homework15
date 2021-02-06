package cursor.library.services;

import cursor.library.dao.UserDAO;
import cursor.library.entities.Book;
import cursor.library.entities.User;

import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User getUserById(int id){
        return userDAO.getUserByID(id);
    }

    public void createUser(User user){
        userDAO.createUser(user);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void removeUserById(int id){
        userDAO.removeUserById(id);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public List<Book> getBooksByUserId(int id){
        return userDAO.getBooksByUserId(id);
    }

    public List<Book> getBooksByUserIdUsingQuery(int id) {
        return userDAO.getBooksByUserIdUsingQuery(id);
    }
}
