package fpt.edu.daos;

import fpt.edu.entities.Book;
import fpt.edu.utilities.HibernateUtility;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Truong Duc Duong
 */
public class BookDao extends GenericDao<Book> {

    @SuppressWarnings("unchecked")
    public List<Book> search(String search) throws SQLException {
        if (search == null || "".equals(search)) {
            return getAll();
        }
        List <Book> list = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            list = session.createQuery("from Book where " +
                    "name like '%" + search + "%' or " +
                    "author like '%" + search + "%' or " +
                    "genre like '%" + search + "%' or " +
                    "publisher.name like '%" + search + "%' or " +
                    "publisher.address like '%" + search + "%' or " +
                    "publisher.contactPerson like '%" + search + "%' or " +
                    "publisher.phone like '%" + search + "%'"
            ).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Fail to retrieve list of " + getEntityClass().getSimpleName() + " from database", e);
        }
        return list;
    }
}
