package hiber.dao;

import java.util.List;
import java.util.Map;

import hiber.entity.Human;
import hiber.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HumanDaoImplements<T> implements IDaoHibernate<T> {

    public HumanDaoImplements (){}

    private SessionFactory sessionFactory;

    public HumanDaoImplements(Class<T> cl, SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        if (sessionFactory == null)
            throw new RuntimeException("null!!!");
    }

    @Override
    public Human get(Integer id) {
        System.out.println(id);
        return HibernateUtil.getSessionFactory().openSession().get(Human.class, id);
    }

    @Override
    public T save(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public void update(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(String hsql, Map<String, Object> params) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hsql);
        if (params != null) {
            for (String i : params.keySet()) {
                query.setParameter(i, params.get(i));
            }
        }

        List<T> result = null;
        if ((!hsql.toUpperCase().contains("DELETE"))
                && (!hsql.toUpperCase().contains("UPDATE"))
                && (!hsql.toUpperCase().contains("INSERT"))) {
            result = query.list();
        }
        session.getTransaction().commit();

        return result;
    }

}
