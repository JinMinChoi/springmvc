package practice.springmvc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.springmvc.Author;
import practice.springmvc.Book;
import practice.springmvc.BookJsonView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    @JsonView(BookJsonView.Complex.class)
    public List<Book> getBooks() {
        return books();
    }

    private List<Book> books() {
        Author author = Author.builder()
                .firstName("jinmin")
                .lastName("choi")
                .email("jimin2216@naver.com")
                .address("bucheon")
                .id(100L)
                .joinedAt(new Date())
                .build();

        Book book = Book.builder()
                .id(1L)
                .title("Spring boot")
                .isbn("1")
                .published(new Date())
                .build();
        book.addAuthor(author);

        return Arrays.asList(book);
    }
}
