package com.example.MovingMate.repository.company;

import com.example.MovingMate.entity.admin.AdminEntity;
import com.example.MovingMate.entity.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {

    Optional<CompanyEntity> findByCompanyId(String companyId);
}
