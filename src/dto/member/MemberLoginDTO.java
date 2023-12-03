package dto.member;

public class MemberLoginDTO {
    private Long memberKey;
    private String memberId;
    private String memberPw;
    private String memberName;

    public MemberLoginDTO() {
    }

    public MemberLoginDTO(Long memberKey,String memberId, String memberPw, String memberName){
        this.memberKey=memberKey;
        this.memberId=memberId;
        this.memberPw=memberPw;
        this.memberName=memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public Long getMemberKey() {
        return memberKey;
    }

    public void setMemberKey(Long memberKey) {
        this.memberKey = memberKey;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}