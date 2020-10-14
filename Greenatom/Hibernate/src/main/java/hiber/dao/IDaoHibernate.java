package hiber.dao;

import java.util.List;
import java.util.Map;

public interface IDaoHibernate<T> {

    public T get(Class<T> cl, Integer id);

    public T save(T object);

    public void update(T object);

    public void delete(T object);

    public List<T> getAll(String hsql, Map<String, Object> params);

}
