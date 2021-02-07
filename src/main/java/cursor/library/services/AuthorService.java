package cursor.library.services;

import cursor.library.dao.AuthorDAO;
import cursor.library.entities.Author;

public class AuthorService {
    AuthorDAO authorDAO = new AuthorDAO();

    public void createAuthor(Author author){
        authorDAO.createAuthor(author);
    }

    public void updateAuthor(Author author){
        authorDAO.updateAuthor(author);
    }

    public Author getAuthorById(int id){
        return authorDAO.getAuthorByID(id);
    }

    public void removeAuthor(Author author){
        authorDAO.removeAuthor(author);
    }
}
