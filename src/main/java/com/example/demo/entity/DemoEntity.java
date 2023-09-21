package com.example.demo.entity;

import javax.persistence.*;

@Entity
// 테이블이라 정의함
public class DemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}