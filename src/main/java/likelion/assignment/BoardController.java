package likelion.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String list(Model model) {
        List<Board> list = boardService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/addForm")
    public String addForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@RequestParam String title, @RequestParam String author) {
        Board board = new Board(title, author, LocalDate.now());
        boardService.save(board);
        return "redirect:/saved";
    }
    @GetMapping("/saved")
    public String saved() {
        return "saved";
    }

    @GetMapping("/close")
    public String close() {
        return "close";
    }


}
