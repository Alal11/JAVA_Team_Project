package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.member.*;
import gui.MyPageMemberDelete;
import login.LoginMember;

import javax.swing.*;

public class MemberApi {
    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();

    // 회원가입 (테스트 성공!)
    public static void signup(MemberSignupDTO memberSignupDTO){
        String endPoint = "/member/signup";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(memberSignupDTO);
            HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);
        } catch (JsonProcessingException e) {
            JOptionPane.showMessageDialog(null, "회원가입 오류 : 중복된 아이디", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("회원가입 오류");
        }
    }

    // 로그인 (테스트 성공!)
    public static void login(MemberLoginDTO memberLoginDTO)  {
        String endPoint = "/member/login";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(memberLoginDTO);
            String response = HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);
            MemberLoginDTO loginResponse = mapper.readValue(response, new TypeReference<>() {
            });
            LoginMember.setMemberKey(loginResponse.getMemberKey());
            LoginMember.setMemberId(loginResponse.getMemberId());
            LoginMember.setMemberName(loginResponse.getMemberName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // 회원 수정 전 비번 확인 ()
    public static void checkPw(MemberCheckPwDTO memberCheckPwDTO){
        String endpoint = "/member/updatePw";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(memberCheckPwDTO);
            HTTP_REQUEST_MANAGER.postRequest(endpoint, requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "비번 확인 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("비번 확인 실패");
        }
    }




    // 회원 수정 (테스트 성공!)
    public static void update(MemberUpdateDTO memberUpdateDTO) {
        String endpoint = "/member/update";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(memberUpdateDTO);
            HTTP_REQUEST_MANAGER.putRequest(endpoint, requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "수정 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("수정 실패");
        }
    }

    // 회원 탈퇴 (테스트 성공!)
    public static void delete(MemberDeleteDTO memberDeleteDTO) {  // Long memberKey로 해?
        String endPoint = "/member/delete";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(memberDeleteDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HTTP_REQUEST_MANAGER.deleteRequest(endPoint, requestBody);
    }

}