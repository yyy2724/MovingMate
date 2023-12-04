package com.example.MovingMate.entity.calender;

import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calender")
public class EventEntity {

    @Id
    @Column(nullable = false, name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;

    @Column(nullable = false)
    private boolean allDay;

//    @OneToMany(mappedBy = "eventEntity", cascade = CascadeType.REMOVE)
//    private List<MoveEntity> moveEntities;
}
