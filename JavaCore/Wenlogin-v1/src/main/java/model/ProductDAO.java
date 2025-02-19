package model;

import config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product (rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getString("pavarta"),
                        rs.getFloat("ptotal"),
                        rs.getString("porigin"),
                        rs.getString("discription")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (pname, pavarta, ptotal, porigin, discription) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getPname());
            stmt.setString(2, product.getPavarta());
            stmt.setFloat(3, product.getPtotal());
            stmt.setString(4, product.getPorigin());
            stmt.setString(5, product.getDiscription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct (Product product) {
        String sql = "UPDATE products SET pname=?, pavatar=?, ptotal=?, porigin=?, description=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getPname());
            stmt.setString(2, product.getPavarta());
            stmt.setFloat(3, product.getPtotal());
            stmt.setString(4, product.getPorigin());
            stmt.setString(5, product.getDiscription());
            stmt.setInt(6, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct (int id) {
        String sql = "DELETE FROM products WHERE id =?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Product product = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getString("pavarta"),
                        rs.getInt("ptotal"),
                        rs.getString("porigin"),
                        rs.getString("discription")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }



}
