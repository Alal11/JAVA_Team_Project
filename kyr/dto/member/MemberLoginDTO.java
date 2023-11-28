package kyr.dto.member;

public class MemberLoginDTO {
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    private String memberPw;

    public String getMemberPw() {
        return memberPw;
    }

    public MemberLoginDTO(String memberId, String memberPw){
        this.memberId=memberId;
        this.memberPw=memberPw;
    }
}
