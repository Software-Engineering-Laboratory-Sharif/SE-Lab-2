package test;

import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
import org.junit.Assert;
import org.junit.Test;

public class LibraryLendBookTest {
    @Test
    public void returnBookTest() {
        //Arrange
        final Library library = new Library();
        final Book book = new Book("title", "mmd", 2);
        final Student ali = new Student("ali", 1);

        //Act
        library.addBook(book);
        final boolean canLend = library.lendBook(book, ali);

        //Assert
        Assert.assertFalse(canLend);
    }
}
