package JavaSwing;
import java.sql.*;

public class Experiment1 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "7261888792";
        
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        
        String query = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
        	String id=resultSet.getString("id");
        	String name=resultSet.getString("name");
            System.out.println("id:"+id+" "+"name:"+name);
        }
        connection.close();
    }
}
