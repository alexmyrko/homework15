package cursor.library;

import cursor.library.entities.Author;
import cursor.library.entities.Book;
import cursor.library.entities.User;
import cursor.library.services.AuthorService;
import cursor.library.services.BookService;
import cursor.library.services.UserService;


public class Main {

    static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        UserService userService = new UserService();
        BookService bookService = new BookService();

        // Define 1st book
        Book spring5 = new Book("Pro Spring 5");
        spring5.addAuthor(new Author("Cosmina, I."));
        spring5.addAuthor(new Author("Harrop, R."));
        spring5.addAuthor(new Author("Schaefer, C."));

        User alex = new User("Oleksandr");
        // Add book to user 'alex'
        alex.addBook(spring5);
        // Store user 'alex' to DB
        userService.createUser(alex);

        // Define 2nd book
        Book thinkInJava = new Book("Think in Java");
        thinkInJava.addAuthor(new Author("Bruce Eckel"));
        // Add 2nd book to user 'alex' and update user in DB
        alex.addBook(thinkInJava);
        userService.updateUser(alex);

        // Create user 'max'
        User max = new User("Max");
        userService.createUser(max);
        // Define 3rd book
        Book effectiveJava = new Book("Effective Java");
        effectiveJava.addAuthor(new Author("Joshua Bloch"));
        // Add 3rd book to user 'max' and update user
        max.addBook(spring5);
        max.addBook(effectiveJava);
        userService.updateUser(max);


//        userService.removeUserById(1);
        System.out.println("User by id = 2:");
        System.out.println(userService.getUserById(2) + "\n");

        System.out.println("All users:");
        for(User user : userService.getAllUsers())
            System.out.println(user.toString());
        System.out.println();

        System.out.println("Book by id = 1:");
        System.out.println(bookService.getBookById(1) + "\n");

        int userId = 2;
        System.out.println(String.format("Books of user with id = %d: \nuser: %s\nbooks: %s",
                userId, userService.getUserById(userId).getName(), userService.getBooksByUserId(userId)));
        System.out.println("------------------------");

        // Get books by userId using named query in Book entity
        userId = 1;
        System.out.println(String.format("Books of user with id = %d: \nuser: %s\nbooks: %s",
                userId, userService.getUserById(userId).getName(), userService.getBooksByUserIdUsingQuery(userId)));

    }
}
