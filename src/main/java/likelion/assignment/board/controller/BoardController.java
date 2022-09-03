package likelion.assignment.board.controller;

import likelion.assignment.board.domain.Board;
import likelion.assignment.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/pagingList")
    public String getPagingList(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("pagingList", boardService.getPagingList(pageable));
        return "pagingList";
    }
}
