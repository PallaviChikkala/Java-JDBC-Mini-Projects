package LibraryManagementSystem;

import java.util.*;
import java.sql.*;

public class SelectBook
{
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "your_sql_password";

        String query = "SELECT title,author FROM book WHERE book_id = ?;";

        try(
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
        )
        {
            System.out.print("Enter the Book ID to search: ");
            int input = sc.nextInt();

            st.setInt(1, input);

            ResultSet rs = st.executeQuery();

            if(rs.next())
            {
                System.out.println("Book ID: "+input+"\nTitle: "+rs.getString("title")+"\nAuthor: "+rs.getString("author"));
            }
            else
            {
                System.out.println("Book not found.");
            }

            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}