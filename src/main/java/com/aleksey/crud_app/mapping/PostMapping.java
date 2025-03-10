package com.aleksey.crud_app.mapping;

import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.model.PostStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostMapping {

    public static List<Post> postMapping(ResultSet resultSet) {
        List<Post> postList = new ArrayList<>();
        Post selectPost = null;
        int currentPostId = -1;

            try {
                if (resultSet.next()) {
                    while (resultSet.next()) {

                        int postId = resultSet.getInt("post.id");
                        if (currentPostId != postId) {
                            selectPost = new Post();
                            selectPost.setId(postId);
                            selectPost.setContent(resultSet.getString("post.content"));
                            selectPost.setCreated(resultSet.getString("post.created"));
                            selectPost.setUpdated(resultSet.getString("post.updated"));
                            selectPost.setWriterId(resultSet.getInt("post.writer_id"));
                            selectPost.setPostStatus(PostStatus.valueOf(resultSet.getString("post.post_status")));

                            postList.add(selectPost);

                            currentPostId = postId;
                        }

                        Label lb = new Label();
                        int currentLabelId = resultSet.getInt("label.id");
                        lb.setId(currentLabelId);
                        lb.setName(resultSet.getString("label.name"));


                        if (selectPost.getLabels() == null) {
//                            selectPost.setLabels(new ArrayList<>());
                            selectPost.getLabels().add(lb);
                        } else selectPost.getLabels().add(lb);
                    }

                } else {
                    System.out.println("Id is incorrect");
                    throw new NullPointerException();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return postList;
    }
}
