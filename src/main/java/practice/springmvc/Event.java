package practice.springmvc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class Event {
    private Integer id;

    @NotBlank
    private String name;

    @Min(0)
    private Integer limit;
}
