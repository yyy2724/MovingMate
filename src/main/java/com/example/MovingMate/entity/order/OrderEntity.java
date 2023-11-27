package com.example.MovingMate.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "m_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_title")
    private String title; // 이사서비스 종류

    @Column(name = "order_phone")
    private String phone;

    @Column(name = "order_departure")
    private String departure;   // 출발지

    @Column(name = "order_destination")
    private String destination; // 도착지

}
