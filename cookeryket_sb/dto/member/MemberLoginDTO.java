package com.example.cookeryket_sb.dto.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberLoginDTO {
    private Long memberKey;
    private String memberId;
    private String memberPw;
    private String memberName;

    @Builder
    public MemberLoginDTO(Long memberKey, String memberId, String memberPw, String memberName){
        this.memberKey=memberKey;
        this.memberId=memberId;
        this.memberPw=memberPw;
        this.memberName=memberName;
    }
}