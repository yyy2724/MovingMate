package com.example.MovingMate.repository.company;

import com.example.MovingMate.entity.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Query("select count(*) from CompanyEntity m where m.email = :email")
    int findByEmail1(@Param("email") String email);

    Optional<CompanyEntity> findByEmail(@Param("email") String email);

    @Query("select count(*) from CompanyEntity m where m.businessNumber = :businessNumber")
    int findByBusinessNumber(@Param("businessNumber") String businessNumber);

    @Query("select count(*) from CompanyEntity m where m.companyName = :companyName")
    int findByCompanyName(@Param("companyName") String companyName);

    @Query("select count(*) from CompanyEntity m where m.phone = :phone")
    int findByPhone(@Param("phone") String phone);
}
