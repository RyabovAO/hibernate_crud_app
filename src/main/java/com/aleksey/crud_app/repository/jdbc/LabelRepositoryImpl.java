package com.aleksey.crud_app.repository.jdbc;

import com.aleksey.crud_app.hibernate_running.HibernateUtil;
import com.aleksey.crud_app.model.Label;
import com.aleksey.crud_app.repository.LabelRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label getById(Long labelId) {
        Label selectLabel;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Label l WHERE l.id = :id", Label.class)
                    .setParameter("id", labelId);
            selectLabel = (Label) query.getSingleResult();
        }

        return selectLabel;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labels;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Label", Label.class);
            labels = query.getResultList();
        }

        return labels;
    }

    @Override
    public Label create(Label label) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(label);
            session.getTransaction().commit();
        }

        return label;
    }

    @Override
    public Label update(Label label) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(label);
            session.getTransaction().commit();
        }
        return label;
    }

    @Override
    public void deleteById(Long labelId) {
        Label label = getById(labelId);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.remove(label);
            session.getTransaction().commit();
        }
    }
}
