package com.aleksey.crud_app.repository.jdbc;

import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Writer;
import com.aleksey.crud_app.repository.WriterRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {


    private long getIdCount(Session session) {

        Query getCountId = session.createQuery("SELECT COUNT(id) FROM Writer");

        return (long) getCountId.getSingleResult() + 1;
    }


    @Override
    public Writer getById(Long writerId) {
        Writer selectWriter;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            selectWriter = session.get(Writer.class, writerId);
        }

        return selectWriter;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Writer", Writer.class);
            writers = query.getResultList();
        }
        return writers;
    }

    @Override
    public Writer create(Writer writer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            long id = getIdCount(session);
            writer.setId(id);
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
    public void delete(Long writerId) {
        Writer writer = getById(writerId);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.remove(writer);
            session.getTransaction().commit();
        }
    }
}
