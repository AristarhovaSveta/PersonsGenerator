package core.dao;

import core.domain.entity.Person;
import core.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonsDao {
    public void save(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        session.close();
    }

    public List<Person> getAll() {
        return (List<Person>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from Person")
                .list();
    }

    public boolean isFioExists(String surname, String name, String middlename) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Person p where p.surname = :surname and p.name = :name and p.middlename = :middlename");
        query.setParameter("surname", surname);
        query.setParameter("name", name);
        query.setParameter("middlename", middlename);
        return query.uniqueResult() != null;
    }
}
