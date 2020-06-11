package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;

/**
 * DaoManager is a general manager class for Data Access Objects
 * It is responsible for CRUD operations on Database
 *
 * @param <T> type of the Entity
 */
public class DaoManager<T> {

    /**
     * Type object of T entity
     */
    private final Class<T> type;

    /**
     * Table name of corresponding SQL table for the T entity
     */
    private final String tableName;

    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     * @param tableName table name of T entity
     */
    public DaoManager(Class<T> type, String tableName) {
        this.type = type;
        this.tableName = tableName;
    }

    /**
     * Starts the transaction to database
     * Tries to save the given entity to database
     * If transaction fails, rolls back the database to last stable point
     *
     * @param data data to be saved to database
     * @return success of save operation
     */
    public boolean save(T data) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(data);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get entity from database by primary key
     *
     * @param id primary key in database
     * @return entity or null
     */
    public T get(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T data = session.get(type, id);
            transaction.commit();
            return data;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get all entities from database table
     *
     * @return entities or null
     */
    public List<T> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String queryStr = "from " + tableName;
            return query(queryStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates custom query for this entity
     *
     * @param queryStr query string
     * @return queried entities or null
     */
    public List<T> query(String queryStr) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(queryStr).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Starts the transaction to database
     * Tries to update the given entity in database
     * If transaction fails, rolls back the database to last stable point
     *
     * @param data updated version of existing entity from database
     * @return success of update operation
     */
    public boolean update(T data) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(data);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Starts the transaction to database
     * Tries to delete the given entity from database
     * If transaction fails, rolls back the database to last stable point
     *
     * @param data entity to delete from database
     * @return success of delete operation
     */
    public boolean delete(T data) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(data);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
