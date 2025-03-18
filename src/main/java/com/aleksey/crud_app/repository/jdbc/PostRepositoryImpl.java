package com.aleksey.crud_app.repository.jdbc;

import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.repository.PostRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post getById(Long postId) {
        Post selectPost;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Post p LEFT JOIN FETCH p.labels WHERE p.id = :id", Post.class)
                    .setParameter("id", postId);
            selectPost = (Post) query.getSingleResult();
        }

        return selectPost;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Post p LEFT JOIN FETCH p.labels", Post.class);
            posts = query.getResultList();
        }
        return posts;
    }

    @Override
    public Post create(Post post) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
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
    public void deleteById(Long postId) {
        Post post = getById(postId);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.remove(post);
            session.getTransaction().commit();
        }
    }
}
