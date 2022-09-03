package likelion.assignment.board.service;

import likelion.assignment.board.domain.Board;
import likelion.assignment.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        String title = board.getTitle();
        String author = board.getAuthor();
        Board created = Board.of(title, author, 0, null, LocalDate.now());

        return boardRepository.save(created);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    public List<Board> getList() {
        return boardRepository.findAll();
    }

    public Page<Board> getPagingList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
