package likelion.assignment.post.controller;

import likelion.assignment.post.service.PostService;
import likelion.assignment.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Post> all = postService.findAll();
        if (all.size() >= 1) {
            System.out.println("all.get(0) = " + all.get(0));
        }
        model.addAttribute("all", all);
        return "post/index";
    }

    @GetMapping("/save")
    public String save() {
        return "post/save";
    }

    @PostMapping("/save")
    public String save(Post post) {
        postService.save(post, LocalDate.now());
        System.out.println("post = " + post);
        return "redirect:/post/saved";
    }

    @GetMapping("/saved")
    public String saved() {
        return "post/saved";
    }

    @GetMapping("/close")
    public String close() {
        return "post/close";
    }

}
