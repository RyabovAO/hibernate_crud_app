package com.aleksey.crud_app.services;

import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.repository.PostRepository;
import com.aleksey.crud_app.repository.jdbc.PostRepositoryImpl;

import java.util.List;

public class PostService {

    private PostRepository postRepository;

    public PostService () {
        postRepository = new PostRepositoryImpl();
    }

    public Post createPost(Post post) {
        return postRepository.create(post);
    }

    public Post updatePost(Post post) {
        return postRepository.update(post);
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPost() {
        return postRepository.getAll();
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
