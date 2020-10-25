package Human;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HumanDao implements IDao {


    @Override
    public Human get(Integer id) {
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM human WHERE human_id= " + id);
            if (resultSet.next()) {
                Human human = new Human();
                human.setId(resultSet.getInt("human_id"));
                human.setName(resultSet.getString("human_name"));
                human.setAdress(resultSet.getString("human_adress"));
                human.setBirth(resultSet.getDate("human_birth"));
                human.setMarried(resultSet.getBoolean("human_married"));
                System.out.println(human.getId());
                return human;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void getAll() {
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
            humans.forEach(System.out::println);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insert(Human human) {
        ConnectionDB connector = new ConnectionDB();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO human (human_id, human_name, human_adress, human_birth, human_married) VALUES (9, (?), (?), (?), (?))");
            preparedStatement.setString(1, human.getName());
            preparedStatement.setString(2, human.getAdress());
            preparedStatement.setDate(3, new java.sql.Date(human.getBirth().getTime()));
            preparedStatement.setBoolean(4, human.getMarried());

            int i = preparedStatement.executeUpdate();
            if (i > -1) {
                return true;
            }
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
                            " human_adress=?, human_birth=?, human_married=? WHERE human_id ");
            preparedStatement.setString(1, human.getName());
            preparedStatement.setString(2, human.getAdress());
            preparedStatement.setDate(3, new java.sql.Date(human.getBirth().getTime()));
            preparedStatement.setBoolean(4, human.getMarried());
            int i = preparedStatement.executeUpdate();
            if (i > -1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
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
        human.setAdress(rs.getString("human_adress"));
        human.setBirth(rs.getDate("human_birth"));
        human.setMarried(rs.getBoolean("human_married"));
        return human;
    }
}
