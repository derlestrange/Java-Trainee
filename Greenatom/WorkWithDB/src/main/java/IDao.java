
/*
User: создание записи, обновление записи, удаление записи, получение записи по id,
получение списка записей (причем с фильтрацией по полям и с пагинацией).
 */

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    Human get(int id) throws SQLException;
    List<Human> getAll();
    boolean insert(Human human);
    boolean update();
    boolean delete(int id);
}