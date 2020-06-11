package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * DaoManager is a general manager class for Data Access Objects
 * It is responsible for CRUD operations on Database
 *
 * @param <T> type of the Entity
 */
public class DaoManager<T> {

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
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
