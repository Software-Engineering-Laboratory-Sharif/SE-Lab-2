package test;


import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LibraryReturnBookTest {
    @Test
    public void returnBookTest(){
        //Arrange
        final Library library = new Library();
        final Book book = new Book("title", "mmd", 2);
        final Student ali = new Student("ali", 1);

        //Act
        library.addStudent(ali);
        library.addBook(book);
        library.lendBook(book, ali);
        library.returnBook(book, ali);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add(2);
        Assert.assertEquals(library.searchBooks(SearchByType.ID, searchList), null);
    }
}
