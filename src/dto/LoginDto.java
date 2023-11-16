package dto;

public class LoginDto {

    private String memberId;
    private String memberPw;

    public LoginDto(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }
}
