package test;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LibrarySearchTest {
    @Test
    public void searchStudentTest(){
        //Arrange
        final Library library = new Library();
        final Student ali = new Student("ali", 1);
        final Student nima = new Student("nima", 2);
        final Student mmd = new Student("mmd", 3);

        //Act
        library.addStudent(ali);
        library.addStudent(nima);
        library.addStudent(mmd);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add(2);

        final ArrayList<Student> expected = new ArrayList<>();
        expected.add(nima);
        Assert.assertEquals(library.searchBooks(SearchByType.ID, searchList), expected);
    }

    @Test
    public void searchBookTest(){
        //Arrange
        final Library library = new Library();
        final Book book = new Book("title", "mmd", 1);
        final Book book1 = new Book("title1", "hashem", 2);
        final Book book2 = new Book("title2", "nima", 3);

        //Act
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add(1);

        final ArrayList<Book> expected = new ArrayList<>();
        expected.add(book);
        Assert.assertEquals(library.searchBooks(SearchByType.ID, searchList), expected);
    }
}
