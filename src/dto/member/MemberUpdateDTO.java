package dto.member;


public class MemberUpdateDTO {
    private Long memberKey;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;

    public MemberUpdateDTO() {
    }

    public MemberUpdateDTO(Long memberKey, String memberPw, String memberName, String memberPhone, String memberEmail, String memberAddress) {
        this.memberKey = memberKey;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberAddress = memberAddress;
    }

    public Long getMemberKey() {
        return memberKey;
    }

    public void setMemberKey(Long memberKey) {
        this.memberKey = memberKey;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
}
