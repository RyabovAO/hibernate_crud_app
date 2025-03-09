package com.aleksey.crud_app.repository.jdbc;

import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.repository.PostRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {


    private long getIdCount(Session session) {

        Query getCountId = session.createQuery("SELECT COUNT(id) FROM Post");

        return (long) getCountId.getSingleResult() + 1;
    }

    @Override
    public Post getById(Long postId) {
        Post selectPost;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            selectPost = session.get(Post.class, postId);
        }

        return selectPost;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Post", Post.class);
            posts = query.getResultList();
        }
        return posts;
    }

    @Override
    public Post create(Post post) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            long id = getIdCount(session);
            post.setId(id);
            session.beginTransaction();
            session.persist(post);
            session.getTransaction().commit();
        }

        return post;
    }

    @Override
    public Post update(Post post) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(post);
            session.getTransaction().commit();
        }
        return post;
    }

    @Override
    public void delete(Long postId) {
        Post post = getById(postId);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.remove(post);
            session.getTransaction().commit();
        }
    }
}
