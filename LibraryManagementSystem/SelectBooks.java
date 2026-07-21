package LibraryManagementSystem;

import java.sql.*;

public class SelectBooks {
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
        String username = "root";
        String password = "Pallavi@2007";

        String query = "SELECT * FROM book;";

        try
        (
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();
        )
        {
            System.out.println("------------------------------------------------------------");
            System.out.println("Book ID\t\tTitle\t\tAuthor\t\tAvailable");
            System.out.println("------------------------------------------------------------");

            while(rs.next())
            {
                System.out.println(
                    rs.getInt("book_id") + "\t\t" +
                    rs.getString("title") + "\t\t" +
                    rs.getString("author") + "\t\t" +
                    rs.getBoolean("available") + "\t\t"
                );
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
