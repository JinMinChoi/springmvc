package practice.springmvc;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class Book {
    @JsonView(BookJsonView.Simple.class)
    private Long id;

    @JsonView(BookJsonView.Simple.class)
    private String isbn;

    @JsonView(BookJsonView.Complex.class)
    private Date published;

    @JsonView(BookJsonView.Complex.class)
    private Set<Author> authors;

    @JsonView(BookJsonView.Simple.class)
    private String title;

    public void addAuthor(Author author) {
        Set<Author> s = new HashSet<>();
        s.add(author);
        this.authors = s;
    }
}
