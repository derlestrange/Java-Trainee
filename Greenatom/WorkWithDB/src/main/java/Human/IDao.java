package Human;

import java.sql.SQLException;

public interface IDao {
    Human get(Integer id) throws SQLException;
    void getAll();
    boolean insert(Human human);
    boolean update();
    boolean delete(Integer id);
}