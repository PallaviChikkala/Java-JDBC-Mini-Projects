package LibraryManagementSystem;

import java.sql.*;
import java.util.*;

public class UpdateIssueBook {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "Pallavi@2007";

        String query1 = "UPDATE book SET available = ? WHERE book_id = ?;";

        String query2 = "SELECT * FROM book WHERE book_id = ?;";

        try(
            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement(query1);
            PreparedStatement stt = con.prepareStatement(query2);
        )
        {
            System.out.print("Enter the Book ID to issue: ");
            int input = sc.nextInt();

            stt.setInt(1, input);

            ResultSet rs = stt.executeQuery();

            if(rs.next())
            {
                if(rs.getBoolean("available") == false)
                {
                    System.out.println("The book for entered book id is already issued.");
                }

                else
                {
                    st.setBoolean(1, false);
                    st.setInt(2, input);

                    int count = st.executeUpdate();

                    if(count > 0)
                    {
                        System.out.println("Book issued successfully.");
                    }
                    else
                    {
                        System.out.println("Book not found.");
                    }
                }
                rs.close();
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
