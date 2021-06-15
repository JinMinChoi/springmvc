package practice.springmvc;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Author {
    @JsonView(BookJsonView.Complex.class)
    private Long id;

    @JsonView(BookJsonView.Complex.class)
    private String firstName;

    @JsonView(BookJsonView.Complex.class)
    private String lastName;

    private String email;
    private String address;
    private Date joinedAt;
}
