package entity;

public class User {
    private String userId;
    private String userPw;
    private String userName;
    private String phonenumber;
    private String email;
    private String address;

    public User(String userId, String userPw, String userName, String phonenumber
                , String email, String address) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }

    public User(){}

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
