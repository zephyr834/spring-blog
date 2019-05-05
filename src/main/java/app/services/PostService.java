package app.services;

import app.models.Post;

import java.util.List;

public interface PostService {
    
    List<Post> findAll();
    List<Post> findLatestFive();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);

}
