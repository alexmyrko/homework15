package cursor.library.services;

import cursor.library.dao.BookDAO;
import cursor.library.entities.Book;

import java.util.List;

public class BookService {
    BookDAO bookDAO = new BookDAO();

    public Book getBookById(int id){
        return bookDAO.getBookByID(id);
    }

    public void createBook(Book book){
        bookDAO.createBook(book);
    }

    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

    public void removeBook(Book book){
        bookDAO.removeBook(book);
    }

    public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }
}
