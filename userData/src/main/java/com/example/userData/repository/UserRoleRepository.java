package com.example.userData.repository;

import com.example.userData.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    void deleteByUserId(Long userId);
    void deleteByRoleId(Long roleId);
}
