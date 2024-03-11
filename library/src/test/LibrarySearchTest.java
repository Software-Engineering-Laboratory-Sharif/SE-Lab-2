package test;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class LibrarySearchTest {
    Library library;
    Student ali;
    Student nima;
    Student mmd;
    Book book;
    Book book1;
    Book book2;

    @Before
    public void setup() {
        //Arrange
        library = new Library();
        ali = new Student("ali", 1);
        nima = new Student("nima", 2);
        mmd = new Student("mmd", 3);
        book = new Book("title", "mmd", 1);
        book1 = new Book("title1", "hashem", 2);
        book2 = new Book("title2", "nima", 3);
    }

    @Test
    public void searchByIdStudentTest() {
        //Act
        library.addStudent(ali);
        library.addStudent(nima);
        library.addStudent(mmd);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add(2);

        Assert.assertEquals(library.searchStudents(SearchByType.ID, searchList), List.of(nima));
        Assert.assertFalse(library.searchStudents(SearchByType.ID, searchList).contains(mmd));
    }

    @Test
    public void searchByNameStudentTest() {
        //Act
        library.addStudent(ali);
        library.addStudent(nima);
        library.addStudent(mmd);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add("ali");

        Assert.assertEquals(library.searchStudents(SearchByType.NAME, searchList), List.of(ali));
        Assert.assertFalse(library.searchStudents(SearchByType.NAME, searchList).contains(mmd));
    }


    @Test
    public void searchByNameListStudentTest() {
        //Act
        library.addStudent(ali);
        library.addStudent(nima);
        library.addStudent(mmd);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add("ali");
        searchList.add("nima");

        Assert.assertEquals(library.searchStudents(SearchByType.NAME, searchList), List.of(ali, nima));
        Assert.assertFalse(library.searchStudents(SearchByType.NAME, searchList).contains(mmd));
    }

    @Test
    public void searchByIdBookTest() {
        //Act
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add(2);

        Assert.assertEquals(library.searchBooks(SearchByType.ID, searchList), List.of(book1));
        Assert.assertFalse(library.searchBooks(SearchByType.ID, searchList).contains(book2));
    }

    @Test
    public void searchByAuthorBookTest() {
        //Act
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add("title2");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book2));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book));
    }

    @Test
    public void searchByTitleBookTest() {
        //Act
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add("title");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book1));
    }

    @Test
    public void searchByTitleListBookTest() {
        //Act
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);

        //Assert
        final ArrayList<Object> searchList = new ArrayList<>();
        searchList.add("title");
        searchList.add("title2");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book, book2));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book1));
    }
}
