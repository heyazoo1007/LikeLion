package likelion.assignment.comment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import likelion.assignment.board.domain.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;

    @Builder
    public Comment(String author, String contents, LocalDateTime createdDate) {
        this.author = author;
        this.contents = contents;
    }

    public static Comment of(String author, String contents, LocalDateTime createdDate) {
        Comment comment = Comment.builder()
                .author(author)
                .contents(contents)
                .createdDate(createdDate)
                .build();
        return comment;
    }
}
