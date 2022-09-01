package likelion.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save")
    public String save(@RequestParam String title, @RequestParam String author) {
        boardService.save(title, author);
        return "글이 추가 되었습니다.";
    }

    @GetMapping
    public String list(Model model) {
        List<Board> list = boardService.findAll();
        model.addAttribute("list", list);
        return "/list";
    }
}
