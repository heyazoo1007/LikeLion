package likelion.assignment;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Board {

    private Long id;

    private String title;
    private String author;

    private LocalDate createdDate;

    public Board(String title, String author, LocalDate createdDate) {
        this.title = title;
        this.author = author;
    }
}
