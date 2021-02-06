package cursor.library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public User(){
        books = new ArrayList<>();
    }

    public User(String name){
        this.name = name;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        book.setUser(this);
        books = this.getBooks();
        books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder booksList = new StringBuilder("");
        for (Book book : books)
            booksList.append(book.getName() + "; ");
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + booksList +
                '}';
    }
}
