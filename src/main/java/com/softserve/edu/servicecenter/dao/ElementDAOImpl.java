package com.softserve.edu.servicecenter.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementDAOImpl<E> implements ElementDao {
    private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Override
    public void addElement(Object element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public void updateElement(Object element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public E getElementByID(Long elementId) {
        Session session = null;
        E element = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            element = (E) session.get(elementClass, elementId);
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return element;
    }

    @Override
    public List<E> getAllElements() {
        Session session = null;
        List<E> elements = new ArrayList<E>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            elements = session.createCriteria(elementClass).list();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return elements;
    }

    @Override
    public void deleteElement(Object element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }
}
