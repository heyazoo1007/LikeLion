package likelion.assignment.board.controller.dto;

import likelion.assignment.comment.domain.Comment;
import lombok.Getter;

import java.util.List;

@Getter
public class SaveRequestDto {

    private String title;
    private String author;

}
