package login;

import entity.Member;

public class LoginMember {

    private static Member user;

    private static LoginMember loginUser = new LoginMember();

    private LoginMember() {
        user = null;
    }

    public static void setLoginMember(Member user) {
        LoginMember.user = user;
    }

    public static Member getLoginMember() {
        return user;
    }
}
