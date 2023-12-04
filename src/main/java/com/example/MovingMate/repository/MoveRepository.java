package com.example.MovingMate.repository;

import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MoveRepository extends JpaRepository<MoveEntity, Long> {
}
