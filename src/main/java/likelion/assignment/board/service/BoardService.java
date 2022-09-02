package likelion.assignment.board.service;

import likelion.assignment.board.domain.Board;
import likelion.assignment.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getList() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    public Board save(Board board) {
        String title = board.getTitle();
        String author = board.getAuthor();
        Board created = Board.of(title, author, 0, null, LocalDateTime.now());

        return boardRepository.save(created);
    }
}
