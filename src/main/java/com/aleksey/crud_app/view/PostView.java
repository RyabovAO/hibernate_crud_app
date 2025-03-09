package com.aleksey.crud_app.view;

import com.aleksey.crud_app.controller.PostController;
import com.aleksey.crud_app.model.Post;

import java.sql.SQLException;
import java.util.Scanner;

public class PostView {
    private final PostController postController;
    private final Scanner scanner = new Scanner(System.in);

    public PostView() {
        this.postController = new PostController();
    }

    public void getAllPost() {
        postController.getAllPost().forEach(p -> System.out.println(p.toString()));
    }

    public void getPost() {
        System.out.println("Enter post id");
        long id = scanner.nextLong();
        Post post = postController.getPostById(id);
        System.out.println("Post with ID: " + post.toString());
    }

    public void createPost() {
        System.out.println("Enter content");
        String content = scanner.nextLine();
        System.out.println("Enter created");
        String created = scanner.nextLine();
        System.out.println("Enter updated");
        String updated = scanner.nextLine();
        System.out.println("Enter writer id");
        long writerId = scanner.nextLong();

        Post createdPost = postController.createPost(content, created, updated, writerId);

        System.out.println("Created post: " + createdPost);
    }

    public void updatePost() {
        System.out.println("Enter post id");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new content");
        String newContent = scanner.nextLine();
        System.out.println("Enter new created");
        String newCreated = scanner.nextLine();
        System.out.println("Enter new updated");
        String newUpdated = scanner.nextLine();
        System.out.println("Enter new writer id");
        long newWriterId = scanner.nextLong();

        Post updatePost = postController.updatePost(id, newContent, newCreated, newUpdated, newWriterId);

        System.out.println("Post with id update to: " + updatePost);
    }

    public void deletePost() {
        System.out.println("Enter post id");
        long id = scanner.nextLong();
        postController.deletePostById(id);
        System.out.println("Post with id: " + id + " delete");
    }
}
