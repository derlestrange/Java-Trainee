package hiber.service;

import hiber.dao.HumanDaoImplements;
import hiber.dao.IDaoHibernate;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

public class ServiceImplements<T> implements IService<T> {

    private IDaoHibernate<T> dao;
    private Class<T> cl;


    public ServiceImplements(Class<T> cl, SessionFactory sessionFactory) {
        this.cl = cl;
        dao = new HumanDaoImplements<T>(cl, sessionFactory);
    }

    @Override
    public T get(Class<T> cl, Integer id) {
        return (T) dao.get(cl, id);
    }

    @Override
    public T save(T object) {
        return (T) dao.save(object);
    }

    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Override
    public void delete(T object) {
        dao.delete(object);
    }

    @Override
    public List<T> getAll(String hsql, Map<String, Object> params) {
        return (List<T>) dao.getAll(hsql, params);
    }

    @Override
    public List<T> getAll() {
        return getAll("from " + cl.getName(), null);
    }

    @Override
    public void deleteAll() {
        getAll("delete from " + cl.getName(), null);

    }

}