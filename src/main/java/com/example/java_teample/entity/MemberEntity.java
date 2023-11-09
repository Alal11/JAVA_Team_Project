package com.example.java_teample.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "user")  // 테이블 이름
public class MemberEntity {  // 테이블 역할을 함
    @Id  // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increament 지정
    private Integer user_id;

    @Column(unique = true)  // unique 제약조건 추가
    private String email;

    @Column
    private String user_pw;

    @Column
    private String user_name;

    @Column
    private String phone_number;

    @Column String user_address;
}
