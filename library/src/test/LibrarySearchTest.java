package test;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibrarySearchTest {
    @Test
    public void searchByIdStudentTest(){
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

        Assert.assertEquals(library.searchStudents(SearchByType.ID, searchList), List.of(nima));
        Assert.assertFalse(library.searchStudents(SearchByType.ID, searchList).contains(mmd));
    }

    @Test
    public void searchByNameStudentTest(){
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
        searchList.add("ali");

        Assert.assertEquals(library.searchStudents(SearchByType.NAME, searchList), List.of(ali));
        Assert.assertFalse(library.searchStudents(SearchByType.NAME, searchList).contains(mmd));
    }


    @Test
    public void searchByNameListStudentTest(){
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
        searchList.add("ali");
        searchList.add("nima");

        Assert.assertEquals(library.searchStudents(SearchByType.NAME, searchList), List.of(ali, nima));
        Assert.assertFalse(library.searchStudents(SearchByType.NAME, searchList).contains(mmd));
    }

    @Test
    public void searchByIdBookTest(){
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
        searchList.add(2);

        Assert.assertEquals(library.searchBooks(SearchByType.ID, searchList), List.of(book1));
        Assert.assertFalse(library.searchBooks(SearchByType.ID, searchList).contains(book2));
    }

    @Test
    public void searchByAuthorBookTest(){
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
        searchList.add("title2");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book2));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book));
    }

    @Test
    public void searchByTitleBookTest(){
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
        searchList.add("title");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book1));
    }

    @Test
    public void searchByTitleListBookTest(){
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
        searchList.add("title");
        searchList.add("title2");

        Assert.assertEquals(library.searchBooks(SearchByType.TITLE, searchList), List.of(book, book2));
        Assert.assertFalse(library.searchBooks(SearchByType.TITLE, searchList).contains(book1));
    }
}
