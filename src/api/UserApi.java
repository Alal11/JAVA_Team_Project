package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LoginDto;
import entity.User;
import login.LoginUser;

import javax.swing.*;

public class UserApi {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();

    /** ---------------------------------------------------------------------------------------------------
     * 회원가입
     */
    public static void signUp(User member) {

        String endPoint = "/user/signup";
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(member);
            HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "회원가입 오류: 중복된 아이디 입니다.", "EveryBook", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("회원가입 오류");
        }


    }

    /** ---------------------------------------------------------------------------------------------------
     * 로그인
     */
    public static void login(LoginDto loginDto) {

        String endPoint = "/user/login/" + loginDto.getUserId() + "?" + "password=" + loginDto.getUserPw();
        String response;
        User user = null;

        try {
            response = HTTP_REQUEST_MANAGER.getRequest(endPoint);
            user = mapper.readValue(response, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.", "EveryBook", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("존재하지 않는 회원입니다. ㅋ");
        }

        LoginUser.setLoginUser(user);
    }

    public static void updateMemberInfo() {
        String updateUserId = LoginUser.getLoginUser().getUserId();

        String endPoint = "/user/" + updateUserId;
        String response;
        User user;

        try {
            response = HTTP_REQUEST_MANAGER.getRequest(endPoint);
            user = mapper.readValue(response, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        LoginUser.setLoginUser(user);
    }
}
