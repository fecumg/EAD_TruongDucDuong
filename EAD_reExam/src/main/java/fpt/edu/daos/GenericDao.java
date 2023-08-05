package fpt.edu.daos;

import fpt.edu.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Truong Duc Duong
 */


public abstract class GenericDao<T> {

    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    @SuppressWarnings("unchecked")
    public GenericDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass()
                            .getGenericSuperclass())
                            .getActualTypeArguments()[0];
    }

    /**
     * Save T
     * @param t
     */
    public void save(T t) throws SQLException {

        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(t);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new SQLException("Error occurred while adding new " + getEntityClass().getSimpleName() + " to database", e);
        }
    }

    /**
     * Update T
     * @param t
     */
    public void update(T t) throws SQLException {

        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(t);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new SQLException("Error occurred while updating " + getEntityClass().getSimpleName() + " in database", e);
        }
    }

    /**
     * Delete T
     * @param id
     */
    public void delete(int id) throws SQLException {

        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            T t = session.get(this.getEntityClass(), id);
            if (t != null) {
                session.delete(t);
                System.out.println(this.getEntityClass().getName() + " is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new SQLException("Error occurred while deleting " + getEntityClass().getSimpleName() + " from database", e);
        }
    }

    /**
     * Get T By id
     * @param id
     * @return t
     */
    public T get(int id) throws SQLException {
        T t;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            t = session.get(this.getEntityClass(), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Fail to retrieve " + getEntityClass().getSimpleName() + " from database", e);
        }
        return t;
    }

    /**
     * Get all T
     * @return list
     */
    @SuppressWarnings("unchecked")
    public List< T > getAll() throws SQLException {

        List < T > list = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            list = session.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Fail to retrieve list of " + getEntityClass().getSimpleName() + " from database", e);
        }
        return list;
    }
}
