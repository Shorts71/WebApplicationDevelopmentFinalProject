package com.example.FinalProject.repository;

import com.example.FinalProject.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;

    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO users (username, email) values (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail());
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";

        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));

                return user;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public User findById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();

                user.setUserId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));

                return user;
            }
        };

        List<User> results = jdbcTemplate.query(sql, rowMapper, id);

        return results.isEmpty() ? null : results.get(0);
    }
}
