package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Brand;
import com.example.FinalProject.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepo {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        String sql = "INSERT INTO products (name, price, description, brand_id, stock_count) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getBrand().getId(),
                product.getStockCount());
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";

        RowMapper<Product> rowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setStockCount(rs.getInt("stock_count"));

                Brand brand = new Brand();
                brand.setId(rs.getLong("brand_id"));
                product.setBrand(brand);

                return product;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Product findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";

        RowMapper<Product> rowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();

                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setStockCount(rs.getInt("stock_count"));

                Brand brand = new Brand();
                brand.setId(rs.getLong("brand_id"));
                product.setBrand(brand);

                return product;
            }
        };

        List<Product> results = jdbcTemplate.query(sql, rowMapper, id);

        return results.isEmpty() ? null : results.get(0);
    }
}
