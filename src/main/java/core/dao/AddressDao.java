package core.dao;

import core.domain.entity.Address;
import core.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {
    public Long save(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Long saved = (Long) session.save(address);
        tx.commit();
        session.close();
        return saved;
    }

    public void update(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(address);
        tx1.commit();
        session.close();
    }

    public void save(List<Address> addresses) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        for (Address address : addresses) {
            session.save(address);
        }
        tx.commit();
        session.close();
    }

    public List<Address> getAll() {
        return (List<Address>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from Address")
                .list();
    }
}
