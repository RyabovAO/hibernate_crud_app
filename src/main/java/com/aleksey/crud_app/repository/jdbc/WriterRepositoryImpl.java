package com.aleksey.crud_app.repository.jdbc;

import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.model.Post;
import com.aleksey.crud_app.model.Writer;
import com.aleksey.crud_app.repository.WriterRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer getById(Long writerId) {
        Writer selectWriter;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts WHERE w.id = :id", Writer.class)
                    .setParameter("id", writerId);
            selectWriter = (Writer) query.getSingleResult();
            selectWriter.toString();
        }
        return selectWriter;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Writer AS w LEFT JOIN FETCH w.posts", Writer.class);
            writers = query.getResultList();
            writers.toString();
        }
        return writers;
    }

    @Override
    public Writer create(Writer writer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Long writerId) {
        Writer writer = getById(writerId);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(writer);
            session.getTransaction().commit();
        }
    }
}
