package com.example.cookeryket_sb.dto.member;

public class MemberCheckPwDTO {

    private Long memberKey;
    private String memberPw;

    public MemberCheckPwDTO(Long memberKey, String memberPw){
        this.memberKey=memberKey;
        this.memberPw=memberPw;

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


}