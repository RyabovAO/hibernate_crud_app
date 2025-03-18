package com.aleksey.crud_app.controller;

import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.repository.jdbc.PostRepositoryImpl;
import com.aleksey.crud_app.services.PostService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    public Post createPost(String content, String created, String updated, long writerId) {
        Post post = new Post();
        post.setContent(content);
        post.setCreated(created);
        post.setUpdated(updated);
        post.setWriterId(writerId);
        return postService.createPost(post);
    }

    public Post updatePost(Long id, String content, String created, String updated, long writeId) {
        Post post = new Post();
        post.setId(id);
        post.setContent(content);
        post.setCreated(created);
        post.setUpdated(updated);
        post.setWriterId(writeId);
        return postService.updatePost(post);
    }

    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }

    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    public void deletePostById(Long id) {
        postService.deletePostById(id);
    }
}
