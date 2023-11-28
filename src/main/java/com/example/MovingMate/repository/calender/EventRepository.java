package com.example.MovingMate.repository.calender;

import com.example.MovingMate.entity.calender.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
