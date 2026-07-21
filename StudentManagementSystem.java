import java.sql.*;

/*
1. import the packages
2. load and register the driver
3. establish the connection
4. create a statement
5. execute the query
6. process the result
7. close the statement and connection
*/

public class StudentManagementSystem {
    public static void main(String args[]) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
        String userName = "root";
        String password = "Pallavi@2007";
        String query = "INSERT INTO student(id, name, age, course) VALUES (?, ?, ?, ?);";

        Connection con = DriverManager.getConnection(url, userName, password);

        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1,5);
        st.setString(2,"Bob");
        st.setInt(3,20);
        st.setString(4,"ECE");

        int count = st.executeUpdate();    
        
        // while(rs.next())
        // {
        //     String userData = rs.getInt(1) + ": "+ rs.getString("name") +", "+rs.getInt("age") +", "+rs.getString("course");
        //     System.out.println(userData);
        // }
        
        if(count > 0)
        {
            System.out.println("Student inserted successfully");
        }

        // rs.close();
        st.close();
        con.close();
    }
}
