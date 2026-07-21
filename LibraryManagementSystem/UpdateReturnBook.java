package LibraryManagementSystem;

import java.util.*;
import java.sql.*;

public class UpdateReturnBook {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "Pallavi@2007";

        String query = "UPDATE book SET available = ? WHERE book_id = ?;";

        try(
            Scanner sc = new Scanner(System.in);

            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);
        )
        {
            System.out.print("Enter the Book ID to return: ");
            int input = sc.nextInt();

            st.setBoolean(1, true);
            st.setInt(2, input);

            int count = st.executeUpdate();

            if(count > 0)
            {
                System.out.println("Book returned successfully.");
            }
            else
            {
                System.out.println("Book ID does not exist.");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
