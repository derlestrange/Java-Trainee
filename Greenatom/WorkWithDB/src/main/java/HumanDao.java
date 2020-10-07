import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HumanDao implements IDao {

    @Override
    public Human get(int id) {
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM human WHERE human_id= " + id);
            if (resultSet.next()) {
                Human human = new Human();
                human.setId(resultSet.getInt("human_id"));
                human.setName(resultSet.getString("human_name"));
                human.setAdress(resultSet.getString("human_address"));
                human.setBirth(resultSet.getString("human_date"));
                human.setMarried(resultSet.getBoolean("human_married"));
                return human;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Human> getAll() {
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM human");
            List<Human> humans = new LinkedList<>();

            while (resultSet.next()) {
                Human human = resultFromResultSet(resultSet);
                humans.add(human);
            }
            return humans;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Human human) {
        Human h = new Human();
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO human VALUES ////");
            preparedStatement.setString(1, h.getName());
            preparedStatement.setString(2, h.getAdress());
            preparedStatement.setString(3, h.getBirth());
            preparedStatement.setBoolean(4, h.getMarried());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update() {
        Human human = new Human();
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE human SET human_name=?," +
                            " human_address=?, human_birth=?, human_married=? WHERE human_id ");
            preparedStatement.setString(1, human.getName());
            preparedStatement.setString(2, human.getAdress());
            preparedStatement.setString(3, human.getBirth());
            preparedStatement.setBoolean(4, human.getMarried());
            int i = preparedStatement.executeUpdate();
            if (i == 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Human human = new Human();
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM human WHERE human_id= " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Human resultFromResultSet(ResultSet rs) throws SQLException {
        Human human = new Human();
        human.setId(rs.getInt("human_id"));
        human.setName(rs.getString("human_name"));
        human.setAdress(rs.getString("human_address"));
        human.setBirth(rs.getString("human_birth"));
        human.setMarried(rs.getBoolean("human_married"));
        return human;
    }
}
