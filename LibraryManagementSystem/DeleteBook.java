package LibraryManagementSystem;

import java.util.*;
import java.sql.*;

public class DeleteBook {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "your_sql_password";

        String query = "DELETE FROM book WHERE book_id = ?;";

        try
        (
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
        )
        {
            System.out.print("Enter the Book ID you want to delete: ");
            int input = sc.nextInt();

            st.setInt(1, input);

            int count = st.executeUpdate();

            if(count > 0)
            {
                System.out.println("Book deleted successfully.");
            }
            else
            {
                System.out.println("Book is not found.");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
