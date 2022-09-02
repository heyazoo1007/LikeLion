package likelion.assignment.post.service;

import likelion.assignment.post.domain.Post;
import likelion.assignment.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(Post post , LocalDate createdDate) {
        Post created = new Post(post.getTitle(), post.getAuthor(), createdDate);
        postRepository.save(created);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
