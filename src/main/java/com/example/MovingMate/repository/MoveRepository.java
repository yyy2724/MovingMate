package com.example.MovingMate.repository;

import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MoveRepository extends JpaRepository<MoveEntity, Long> {

    Page<MoveEntity> findByIdContains(Pageable pageable, String search);

    @Query("select m from move_save m where m.price = 0 and m.moveWriter like concat('%', :search, '%') ")
    Page<MoveEntity> findByMoveWriterContains(Pageable pageable, @Param("search") String search);

    @Query("select m from move_save m where m.price = 0 and m.firstAddress like concat('%', :search, '%') ")
    Page<MoveEntity> findByFirstAddressContains(Pageable pageable, @Param("search") String search);

    @Query("select m from move_save m where m.price = 0 and m.moveType like concat('%', :search, '%') ")
    Page<MoveEntity> findByMoveTypeContains(Pageable pageable, @Param("search") String search);

    @Query("select m from move_save m where m.price = 0")
    Page<MoveEntity> findMoveAll(Pageable pageable);
}
