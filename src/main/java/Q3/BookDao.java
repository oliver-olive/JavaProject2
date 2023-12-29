package Q3;

import java.sql.*;
import java.util.Scanner;

public class BookDao {

    public void create(Book book) {
        String QUERY = "INSERT INTO books (bookId, bookTitle,bookPrice) VALUES(?, ?, ?)";
        String CHECK_AVAILABLE = "SELECT * FROM books WHERE bookId = ?";
        Connection c1 = getConnect();
        Scanner sc = new Scanner(System.in);
        try {
            PreparedStatement ckps = c1.prepareStatement(CHECK_AVAILABLE);
            ckps.setInt(1, book.bookId);
            ResultSet rs = ckps.executeQuery();
            while(rs.next()){
                System.out.println("That id already exist please enter another id");
                int id = sc.nextInt();
                book.bookId = id;
                ckps.setInt(1, id);
                rs = ckps.executeQuery();
            }
            PreparedStatement ps = c1.prepareStatement(QUERY);
            ps.setInt(1, book.bookId);
            ps.setString(2, book.bookTitle);
            ps.setDouble(3, book.bookPrice);
            System.out.println(book.getBookId());
            int rs1 = ps.executeUpdate();
            if (rs1 > 0) {
                System.out.println("Create successful)");
            } else {
                System.out.println("opps something wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readBook() {
        String QUERY = "SELECT * FROM books";
        Connection c1 = getConnect();
        try {
            PreparedStatement ps = c1.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("bookId") + " " + rs.getString("bookTitle") + " " + rs.getDouble("bookPrice"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int bookId) {
        Scanner sc = new Scanner(System.in);
        String QUERY = "UPDATE books SET bookTitle = ?, bookPrice=? where bookId = ?";
        Connection c = getConnect();
        try {
            PreparedStatement ps = c.prepareStatement(QUERY);
            System.out.println("The title you want to change to");
            String title = sc.next();
            System.out.println("The price you want to change to");
            double price = sc.nextDouble();
            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, bookId);
            int rs = ps.executeUpdate();
            while (!(rs > 0)) {
                System.out.println("That id doesn't exist, Please renter the id. ");
                int id = sc.nextInt();
                ps.setString(1, title);
                ps.setDouble(2, price);
                ps.setInt(3, id);
                rs = ps.executeUpdate();
            }
            System.out.println("System success updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void delete(int bookId) {
        String QUERY = "DELETE FROM books WHERE bookId = ?";
        Connection c = getConnect();
        Scanner sc = new Scanner(System.in);
        try {
            PreparedStatement ps = c.prepareStatement(QUERY);
            ps.setInt(1, bookId);
            int res = ps.executeUpdate();
            while (!(res > 0)) {
                System.out.println("The id you entered doesn't exist please enter again");
                int id = sc.nextInt();
                ps.setInt(1, id);
                res = ps.executeUpdate();
            }
            System.out.println("Success deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnect() {
        final String JDBC_URL = "jdbc:mysql://localhost:3306/sakila";
        final String JDBC_USER = "root";
        final String JDBC_PASSWORD = "123456789";
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
