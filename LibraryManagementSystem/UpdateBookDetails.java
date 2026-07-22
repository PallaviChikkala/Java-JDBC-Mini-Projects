package LibraryManagementSystem;

import java.util.*;
import java.sql.*;

public class UpdateBookDetails {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "your_sql_password";

        String query = "UPDATE book SET title = ?, author = ? WHERE book_id = ?;";

        try(
            Scanner sc = new Scanner(System.in);

            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);
        )
        {
            System.out.print("Enter the Book ID to update: ");
            int ID = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the new title: ");
            String title = sc.nextLine();

            System.out.print("Enter the new Author: ");
            String author = sc.nextLine();

            st.setString(1,title);
            st.setString(2,author);
            st.setInt(3,ID);

            int count = st.executeUpdate();

            if(count > 0)
            {
                System.out.println("Updated book details successfully.");
            }
            else
            {
                System.out.println("Book not found.");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
