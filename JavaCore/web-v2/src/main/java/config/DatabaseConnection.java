package config;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/web-v2";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection () throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Kết nối thất bại");
        }
    }

//    public static void main(String[] args) {
//        try {
//            Connection connection = DatabaseConnection.getConnection();
//            if (connection != null) {
//                System.out.println("Kết nối thành công");
//            } else {
//                System.out.println("Kết nối thất bại");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
