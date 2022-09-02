package likelion.assignment.board.controller;

import likelion.assignment.board.controller.dto.SaveRequestDto;
import likelion.assignment.board.domain.Board;
import likelion.assignment.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/list/save")
    public String save(Board board) {
        Board saved = boardService.save(board);
        return "redirect:/board/list/" + saved.getId();
    }

    @GetMapping("/list/{boardId}")
    public String findById(@PathVariable Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("list", boardService.getList());
        return "list";
    }

    @GetMapping("/list/save")
    public String saveForm() {
        return "saveForm";
    }

}
