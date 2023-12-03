package login;

public class LoginMember {

    private static Long memberKey;
    private static String memberId;
    private static String memberName;


    private LoginMember() {
    }

    public static Long getMemberKey() {
        return memberKey;
    }
    public static String getMemberId() {
        return memberId;
    }
    public static String getMemberName() {
        return memberName;
    }


    public static void setMemberKey(Long memberKey) {
        LoginMember.memberKey = memberKey;
    }
    public static void setMemberId(String memberid) {
        LoginMember.memberId = memberid;
    }

    public static void setMemberName(String memberName) {
        LoginMember.memberName = memberName;
    }
}