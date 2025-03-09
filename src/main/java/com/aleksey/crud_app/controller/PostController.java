package com.aleksey.crud_app.controller;

import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.repository.PostRepository;
import com.aleksey.crud_app.repository.jdbc.PostRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    public PostController() {
        this.postRepository = new PostRepositoryImpl();
    }

    public Post createPost(String content, String created, String updated, long writerId) {
        Post post = new Post();
        post.setContent(content);
        post.setCreated(created);
        post.setUpdated(updated);
        post.setWriterId(writerId);
        return postRepository.create(post);
    }

    public Post updatePost(Long id, String content, String created, String updated, long writeId) {
        Post post = new Post();
        post.setId(id);
        post.setContent(content);
        post.setCreated(created);
        post.setUpdated(updated);
        post.setWriterId(writeId);
        return postRepository.update(post);
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPost() {
        return postRepository.getAll();
    }

    public void deletePostById(Long id) {
        postRepository.delete(id);
    }
}
