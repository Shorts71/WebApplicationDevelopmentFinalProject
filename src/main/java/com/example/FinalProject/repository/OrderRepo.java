package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepo {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Order order) {
        String sql = "INSERT INTO orders (quantity, total_amount, order_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getQuantity(), order.getTotalAmount(), order.getOrderDate());
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";

        RowMapper<Order> rowMapper = new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());

                return order;
            }
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";

        RowMapper<Order> rowMapper = new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());

                return order;
            }
        };

        List<Order> results = jdbcTemplate.query(sql, rowMapper, id);

        return results.isEmpty() ? null : results.get(0);
    }
}
