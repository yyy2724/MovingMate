package com.example.MovingMate.Entity;


import lombok.*;

import javax.persistence.*;

@Entity(name = "move_save")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "move_id")
    private Long id;

    @Column(nullable = false)
    private String moveWriter;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String firstAddress;

    @Column(nullable = false)
    private String endAddress;

    @Column(nullable = false)
    private String moveType;

}
