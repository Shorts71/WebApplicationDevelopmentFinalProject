package com.example.FinalProject.repository;

import com.example.FinalProject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);

    //JPQL
    @Query("Select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u where u.role = 'STAFF'")
    public Page<User> findUserByStaffRole(Pageable pageable);

    @Query("SELECT u FROM User u where u.role = 'MANAGER'")
    public Page<User> findUserByManagerRole(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.role = 'ADMIN'")
    public Page<User> findUserByAdminRole(Pageable pageable);
}
