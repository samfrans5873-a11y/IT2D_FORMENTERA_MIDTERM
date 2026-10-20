package com.laundry.dao;

import com.laundry.model.ScenarioEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDao {

    public void addJobOrder(ScenarioEntity order) {
        String sql = "INSERT INTO job_orders (customer_name, weight_kg, total_amount, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, order.getCustomerName());
            pstmt.setDouble(2, order.getWeightKg());
            pstmt.setDouble(3, order.getTotalAmount());
            pstmt.setString(4, order.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ScenarioEntity> getAllJobOrders() {
        List<ScenarioEntity> orders = new ArrayList<>();
        String sql = "SELECT * FROM job_orders";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(new ScenarioEntity(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getDouble("weight_kg"),
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}