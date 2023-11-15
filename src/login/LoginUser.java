package login;

import entity.User;

public class LoginUser {

    private static User user;

    private static LoginUser loginUser = new LoginUser();

    private LoginUser() {
        user = null;
    }

    public static void setLoginUser(User user) {
        LoginUser.user = user;
    }

    public static User getLoginUser() {
        return user;
    }
}
