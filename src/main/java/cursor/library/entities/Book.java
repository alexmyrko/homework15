package cursor.library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQuery(name = "Book.findBooksByUser", query = "select b from Book b where b.user.id = :id")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Author> authors;

    public Book() {
        authors = new ArrayList<>();
    }

    public Book(String name){
        this.name = name;
        authors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author){
        author.setBook(this);
        authors.add(author);
    }

    @Override
    public String toString() {
        StringBuilder authorsList = new StringBuilder("");
        for (Author author : authors)
            authorsList.append(author.getName() + "; ");
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authorsList +
                '}';
    }
}
