package LibraryManagementSystem;
import java.sql.*;

public class Insert {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "Pallavi@2007";
        String query = "INSERT INTO book(book_id, title, author, available) VALUES (?,?,?,?);";

        try //Automatically closes resources
        (
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);
        )

        {
            // For insertion
            st.setInt(1,105);
            st.setString(2, "SpringBoot");
            st.setString(3, "Pallavi");
            st.setBoolean(4, true);

            int count = st.executeUpdate();

            if(count > 0)
            {
                System.out.println("Book inserted successfully.");
            }

        }

        // Manually closing resources.
        /*
        rs.close();
        st.close();
        con.close();
        */

        // Automatically closing resources
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }   
}
