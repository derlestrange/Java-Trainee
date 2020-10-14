package hiber.service;

import hiber.dao.IDaoHibernate;

import java.util.List;

public interface IService<T> extends IDaoHibernate<T> {

    List<T> getAll();

    void deleteAll();

}
