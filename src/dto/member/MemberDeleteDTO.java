package dto.member;

public class MemberDeleteDTO {
    private Long memberKey;
    private String memberPw;


    public MemberDeleteDTO(Long memberKey, String memberPw){
        this.memberKey =memberKey;
        this.memberPw=memberPw;
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
}
