import java.sql.*;

// Steps to connect Java with the database
/*
1. Import the packages --> java.sql.*;
2. Load and register the driver --> com.mysql.jdbc.Driver
3. Establish the Connection
4. Create the Statement
5. Execute the query
6. Process result
7. Close the Connection and the Statement
*/

public class JDBCDemo {
    public static void main(String args[]) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/InterviewSimulationSystem";
        String userName = "root";
        String password = "Pallavi@2007";
        String query = "SELECT * FROM users;";

        // Class.forName("com.mysql.jdbc.Driver"); // forName is a method
        
        // Establishing a connection
        Connection con = DriverManager.getConnection(url, userName, password);

        // Creating a statement
        // Statement st = con.createStatement();

        // Prepared Statement for dynamic use
        PreparedStatement st = con.prepareStatement(query);

        // int count = st.executeUpdate(query); // DDL, DML, DQL

        // // Executing the query
        ResultSet rs = st.executeQuery();

        // while(rs.next())
        // {
        //     String userData = rs.getInt(1) + " : " + rs.getString("name") + ", " + rs.getString("email");
        //     System.out.println(userData);
        // }

        st.close();
        con.close();
    }
}
