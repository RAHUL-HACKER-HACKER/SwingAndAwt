package JavaSwing;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Experiment4 {

    public static void main(String[] args) throws Exception {

        // Register the driver class.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create a connection string.
        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "7261888792";

        // Create a connection to the database.
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a statement.
        PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (name, email) VALUES (?, ?)");

        // Create a list of data to insert.
        
        List<String> names = Arrays.asList("Rahul", "shiva", "anand", "yashraj", "pankaj");
        List<String> emails = Arrays.asList("rahul@example.com", "shiva@example.com", "anand@example.com", "yashraj@example.com", "pankaj@example.com");

        // Insert the data in batches of 10.
        for (int i = 0; i < names.size(); i += 10) {
            for (int j = i; j < Math.min(i + 10, names.size()); j++) {
                statement.setString(1, names.get(j));
                statement.setString(2, emails.get(j));
                statement.addBatch();
            }
            statement.executeBatch();
        }
        ResultSet rs=statement.executeQuery("select* from Employees;");
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String eamil=rs.getString("email");
			System.out.println(id+" "+name+" "+eamil);
		}

        // Close the connection.
        connection.close();
    }
}
