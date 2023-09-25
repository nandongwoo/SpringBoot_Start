package com.example.demo.entity;

import javax.persistence.*;

@Entity
// 테이블이라 정의함
@Table(name = "demo_table")
public class DemoEntity {
    @Id // Id는 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue = 주요키의 필드값을 자동생성 // strategy = GenerationType.IDENTITY 키값 자동증가열
    private Long id;


    // @Column : database에 컬럼값 자동으로 설정
    //이름 설정이 가능함 (Default는 Entity에 설정한 요소값 여기선 name)
    @Column(name = "student_name")
    private String name;



    // nullable = null일 수있다 false = not null.
    // 컬럼추가 default는 255
    @Column(length = 30, nullable = false, unique = true)
    private String mobile;


    // Database에 컬럼값을 추가 할 땐 람다식으로 들어감 ex) studentAddress => student_Address
    @Column
    private String studentAddress;
}

