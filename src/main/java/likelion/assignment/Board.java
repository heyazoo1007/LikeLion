package likelion.assignment;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
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
