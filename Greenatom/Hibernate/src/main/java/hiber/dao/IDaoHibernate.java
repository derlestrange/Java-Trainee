package hiber.dao;

import hiber.entity.Human;

import java.util.List;
import java.util.Map;

public interface IDaoHibernate<T> {

    public Human get(Integer id);

    public T save(T object);

    public void update(T object);

    public void delete(T object);

    public List<T> getAll(String hsql, Map<String, Object> params);

}
