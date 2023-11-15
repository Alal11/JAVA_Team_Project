package login;

import entity.Member;

public class LoginUser {

    private static Member user;

    private static LoginUser loginUser = new LoginUser();

    private LoginUser() {
        user = null;
    }

    public static void setLoginUser(Member user) {
        LoginUser.user = user;
    }

    public static Member getLoginUser() {
        return user;
    }
}
