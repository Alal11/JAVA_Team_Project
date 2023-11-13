package com.example.java_teample.entity;

import com.example.java_teample.dto.MemberDTO;
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
    private Long user_id;

    @Column(unique = true)  // unique 제약조건 추가
    private String email;

    @Column
    private String user_pw;

    @Column
    private String user_name;

    @Column
    private String phone_number;

    @Column String user_address;

    // dto를 entity로 변환
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity =new MemberEntity();
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setUser_pw(memberDTO.getUser_pw());
        memberEntity.setUser_name(memberDTO.getUser_name());
        memberEntity.setPhone_number(memberDTO.getPhone_number());
        memberEntity.setUser_address(memberDTO.getUser_address());
        return memberEntity;
    }

    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity =new MemberEntity();
        memberEntity.setUser_id(memberDTO.getUser_id());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setUser_pw(memberDTO.getUser_pw());
        memberEntity.setUser_name(memberDTO.getUser_name());
        memberEntity.setPhone_number(memberDTO.getPhone_number());
        memberEntity.setUser_address(memberDTO.getUser_address());
        return memberEntity;
    }
}
