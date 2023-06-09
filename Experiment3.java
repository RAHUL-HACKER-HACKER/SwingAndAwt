package JavaSwing;
import java.sql.*;

public class Experiment3 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "7261888792";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        String createTableSQL = "CREATE TABLE employees (id INT, name VARCHAR(255), email VARCHAR(255))";
        statement.executeUpdate(createTableSQL);

        String insertSQL = "INSERT INTO employees (id, name, email) VALUES (1, 'rahul kumar', 'rahul.kumar@example.com')";
        statement.executeUpdate(insertSQL);

        String selectSQL = "SELECT * FROM employees WHERE id = 1";
        ResultSet resultSet = statement.executeQuery(selectSQL);

        while (resultSet.next()) {
            System.out.println("id:"+resultSet.getInt("id") + "\nname:" + resultSet.getString("name") + "\nemail:" + resultSet.getString("email"));
        }

        String updateSQL = "UPDATE employees SET name = 'rahul kumar' WHERE id = 1";
        statement.executeUpdate(updateSQL);

        String deleteSQL = "DELETE FROM employees WHERE id = 1";
        statement.executeUpdate(deleteSQL);

        connection.close();
    }
}