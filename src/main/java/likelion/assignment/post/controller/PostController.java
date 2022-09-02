package likelion.assignment.post.controller;

import likelion.assignment.post.service.PostService;
import likelion.assignment.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String list(Model model) {
        List<Post> list = postService.findAll();
        model.addAttribute("list", list);
        return "post/list";
    }

    @GetMapping("/addForm")
    public String addForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@RequestParam String title, @RequestParam String author) {
        Post post = new Post(title, author, LocalDate.now());
        postService.save(post);
        return "redirect:/saved";
    }
    @GetMapping("/saved")
    public String saved() {
        return "saved";
    }

    @GetMapping("/close")
    public String close() {
        return "post/close";
    }


}
