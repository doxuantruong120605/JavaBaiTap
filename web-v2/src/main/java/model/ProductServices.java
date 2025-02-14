package model;


import config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServices {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getString("pavatar"),
                        rs.getInt("ptotal"),
                        rs.getFloat("price"),
                        rs.getString("porigin"),
                        rs.getString("category"),
                        rs.getString("storage"),
                        rs.getString("color"),
                        rs.getString("description")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (pname, pavatar, ptotal, price, porigin, category, storage, color, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getPname());
            stmt.setString(2, product.getPavatar());
            stmt.setInt(3, product.getPtotal());
            stmt.setFloat(4, product.getPrice());
            stmt.setString(5, product.getPorigin());
            stmt.setString(6, product.getCategory());
            stmt.setString(7, product.getStorage());
            stmt.setString(8, product.getColor());
            stmt.setString(9, product.getDescription());
            stmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct (Product product) {
        String sql = "UPDATE products SET pname=?, pavatar=?, ptotal=?, price=?, porigin=?, category=?, storage=?, color=?, description=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getPname());
            stmt.setString(2, product.getPavatar());
            stmt.setInt(3, product.getPtotal());
            stmt.setFloat(4, product.getPrice());
            stmt.setString(5, product.getPorigin());
            stmt.setString(6, product.getCategory());
            stmt.setString(7, product.getStorage());
            stmt.setString(8, product.getColor());
            stmt.setString(9, product.getDescription());

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
                        rs.getString("pavatar"),
                        rs.getInt("ptotal"),
                        rs.getFloat("price"),
                        rs.getString("porigin"),
                        rs.getString("category"),
                        rs.getString("storage"),
                        rs.getString("color"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


}