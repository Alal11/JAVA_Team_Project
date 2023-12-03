package test;

import api.MemberApi;
import dto.member.MemberDeleteDTO;
import dto.member.MemberLoginDTO;
import dto.member.MemberSignupDTO;
import dto.member.MemberUpdateDTO;

public class MemberApiTest {
    public static void main(String[] args) {


        // 회원가입 테스트 (성공!)
        MemberSignupDTO memberSignupDTO = new MemberSignupDTO();
        memberSignupDTO.setMemberId("didi1263");
        memberSignupDTO.setMemberPw("qwer125345");
        memberSignupDTO.setMemberName("네트워크");
        memberSignupDTO.setMemberPhone("010-3030-2020");
        memberSignupDTO.setMemberEmail("asdf123@naver.com");
        memberSignupDTO.setMemberAddress("cpu 어쩌구");
        MemberApi.signup(memberSignupDTO);


//        // 로그인 테스트 (성공!)
//        MemberLoginDTO memberLoginDTO = new MemberLoginDTO();
//        memberLoginDTO.setMemberId("didi11");
//        memberLoginDTO.setMemberPw("qwer123");
//        MemberApi.login(memberLoginDTO);
//
//        // 회원 수정 테스트 (성공!)
//        MemberUpdateDTO memberUpdateDTO = new MemberUpdateDTO();
//        memberUpdateDTO.setMemberKey(17L);
//        memberUpdateDTO.setMemberPw("qwer123");
//        memberUpdateDTO.setMemberName("네트워크");
//        memberUpdateDTO.setMemberPhone("010-123-1233");
//        memberUpdateDTO.setMemberEmail("rr@gmail.com");
//        memberUpdateDTO.setMemberAddress("파이팅");
//        MemberApi.update(memberUpdateDTO);
//
//
//        // 회원 탈퇴 테스트 (성공!)
//        MemberDeleteDTO memberDeleteDTO = new MemberDeleteDTO();
//        memberDeleteDTO.setMemberKey(18L);
//        MemberApi.delete(memberDeleteDTO);


    }
}
