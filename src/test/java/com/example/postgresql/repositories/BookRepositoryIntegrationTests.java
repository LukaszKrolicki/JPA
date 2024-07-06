package com.example.postgresql.repositories;

import com.example.postgresql.TestDataUtil;
import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    BookRepository underTest;

    AuthorRepository authorRepository;
    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest, AuthorRepository authorDAO) {
        this.underTest = underTest;
        this.authorRepository = authorDAO;
    }

    @Test
    public void testThatBookCanBeCreatedAndRetrieved() {
        Author author = TestDataUtil.createTestAuthor();
        Book book = TestDataUtil.createBook(author);
        authorRepository.save(author);
        underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultpleBookCanBeCreatedAndRetrieved() {
        Author author = TestDataUtil.createTestAuthor();
        Book book2 = TestDataUtil.createBook2(author);
        authorRepository.save(author);
        underTest.save(book2);
        Author author2 = TestDataUtil.createTestAuthor2();
        authorRepository.save(author2);
        Book book3 = TestDataUtil.createBook3(author2);
        underTest.save(book3);

        Iterable<Book> result = underTest.findAll();

        assertThat(result).hasSize(2).contains(book2, book3);
    }
//
//    @Test
//    public void testUpdateBook(){
//        Book book = TestDataUtil.createBook();
//        Author author = TestDataUtil.createTestAuthor();
//        Author author2=TestDataUtil.createTestAuthor2();
//        authorRepository.create(author2);
//        authorRepository.create(author);
//        book.setAuthorId(author.getId());
//        underTest.create(book);
//        book.setAuthorId(2L);
//        book.setTitle("New Title");
//
//        underTest.update(book, book.getIsbn());
//
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result.isPresent()).isTrue();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testDeleteBook(){
//        Book book = TestDataUtil.createBook();
//        Author author = TestDataUtil.createTestAuthor();
//        authorRepository.create(author);
//        book.setAuthorId(author.getId());
//        underTest.create(book);
//        underTest.delete(book.getIsbn());
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result.isEmpty()).isTrue();
//    }
}