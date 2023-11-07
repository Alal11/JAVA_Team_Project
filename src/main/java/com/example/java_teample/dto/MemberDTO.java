package com.example.java_teample.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동으로 만들어줌
@AllArgsConstructor  // 필드를 모두 매개변수라 하는 생성자를 만들어줌
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
