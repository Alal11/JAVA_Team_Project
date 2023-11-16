package entity;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;

    public Member(String memberId, String memberPw, String memberName, String memberPhone
                , String memberEmail, String memberAddress) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberAddress = memberAddress;
    }

    public Member(){}

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

}
