package com.example.java_teample.dto;


import lombok.*;

// lombok dependency 추가
@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동으로 만들어줌
@AllArgsConstructor  // 필드를 모두 매개변수라 하는 생성자를 만들어줌
@ToString
public class MemberDTO {  // 회원 정보를 필드로 정의
    private Integer user_id;
    private String email;
    private String user_pw;
    private String user_name;
    private String phone_number;
    private String user_address;
}
