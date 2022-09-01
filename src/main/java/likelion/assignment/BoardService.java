package likelion.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findALl();
    }
}
