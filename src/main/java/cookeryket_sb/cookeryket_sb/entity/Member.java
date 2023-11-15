package cookeryket_sb.cookeryket_sb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    private String memberId;

    private String memberPw;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;

    @Builder
    public Member(String memberId, String memberPw, String memberName, String memberPhone
                  ,String memberEmail, String memberAddress
            ) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberAddress = memberAddress;
    }

}
