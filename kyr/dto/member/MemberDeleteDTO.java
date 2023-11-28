package kyr.dto.member;

public class MemberDeleteDTO {
    private Long memberKey;

    public Long getMemberKey() {
        return memberKey;
    }

    private String memberPw;

    public String getMemberPw() {
        return memberPw;
    }

    public MemberDeleteDTO(Long memberKey, String memberPw){
        this.memberKey =memberKey;
        this.memberPw=memberPw;
    }
}
