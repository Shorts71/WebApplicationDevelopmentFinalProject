package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Brand;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BrandRepo {
    private final JdbcTemplate jdbcTemplate;

    public BrandRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Brand brand) {
        String sql = "INSERT INTO brands (brand_name) VALUES (?)";
        jdbcTemplate.update(sql, brand.getBrandName());
    }

    public List<Brand> findAll() {
        String sql = "SELECT * FROM brands";

        RowMapper<Brand> rowMapper = new RowMapper<Brand>() {
            public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
                Brand brand = new Brand();
                brand.setId(rs.getLong("id"));
                brand.setBrandName(rs.getString("brand_name"));

                return brand;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Brand findById(int id) {
        String sql = "SELECT * FROM brands WHERE id = ?";

        RowMapper<Brand> rowMapper = new RowMapper<Brand>() {
            public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
                Brand brand = new Brand();
                brand.setId(rs.getLong("id"));
                brand.setBrandName(rs.getString("brand_name"));

                return brand;
            }
        };

        List<Brand> results = jdbcTemplate.query(sql, rowMapper, id);

        return results.isEmpty() ? null : results.get(0);
    }


}
