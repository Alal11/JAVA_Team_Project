package com.example.java_teample.dto;


import com.example.java_teample.entity.MemberEntity;
import lombok.*;

// lombok dependency 추가
@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동으로 만들어줌
@AllArgsConstructor  // 필드를 모두 매개변수라 하는 생성자를 만들어줌
@ToString
public class MemberDTO {  // 회원 정보를 필드로 정의
    private Long user_id;
    private String email;
    private String user_pw;
    private String user_name;
    private String phone_number;
    private String user_address;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO =new MemberDTO();
        memberDTO.setUser_id(memberEntity.getUser_id());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setUser_pw(memberEntity.getUser_pw());
        memberDTO.setUser_name(memberEntity.getUser_name());
        memberDTO.setPhone_number(memberEntity.getPhone_number());
        memberDTO.setUser_address(memberEntity.getUser_address());
        return memberDTO;

    }
}
