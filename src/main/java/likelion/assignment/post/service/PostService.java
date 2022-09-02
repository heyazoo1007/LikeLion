package likelion.assignment.post.service;

import likelion.assignment.post.domain.Post;
import likelion.assignment.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(Post post) {
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findALl();
    }
}
