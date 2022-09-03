package likelion.assignment.board.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import likelion.assignment.comment.domain.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer likes;

    @OneToMany(mappedBy = "board", fetch =  FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDate createdDate;

    @Builder
    public Board(String title, String author, Integer likes, List<Comment> comments, LocalDate createdDate) {
        this.title = title;
        this.author = author;
        this.likes = likes;
        this.createdDate = createdDate;
        //this.comments = comments;
    }

    public static Board of(String title, String author, Integer likes, List<Comment> comments, LocalDate createdDate) {
        Board board = Board.builder()
                .title(title)
                .author(author)
                .likes(likes)
                .comments(comments)
                .createdDate(createdDate)
                .build();
        return board;
    }
}
