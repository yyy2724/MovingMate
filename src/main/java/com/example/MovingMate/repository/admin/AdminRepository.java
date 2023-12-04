package com.example.MovingMate.repository.admin;

import com.example.MovingMate.entity.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    @Query("SELECT a FROM AdminEntity a where a.adminId = :adminId")
    AdminEntity findOneById(String adminId);

    Optional<AdminEntity> findByAdminId(String admin);
}
