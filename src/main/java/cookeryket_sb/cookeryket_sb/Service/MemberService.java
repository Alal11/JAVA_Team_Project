package cookeryket_sb.cookeryket_sb.Service;

import cookeryket_sb.cookeryket_sb.Repository.MemberRepository;
import cookeryket_sb.cookeryket_sb.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(final Member member) {
//        System.out.println("member = " + member);
        Member joinMember = validateDuplicatedUser(member);
        return memberRepository.save(joinMember);
//        return new Member();
    }

    @Transactional
    Member validateDuplicatedUser(final Member member) {
        log.info("member in validate = {}", member);
        Optional<Member> optionalUser = memberRepository.findByMemberId(member.getMemberId());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        } else {
            return Member.builder()
                    .memberId(member.getMemberId())
                    .memberPw(member.getMemberPw())
                    .memberName(member.getMemberName())
                    .memberPhone(member.getMemberPhone())
                    .memberEmail(member.getMemberEmail())
                    .memberAddress(member.getMemberAddress())
                    .build();
        }
    }

    public List<Member> memberList() {
        return memberRepository.findAll();
    }

    public Optional<Member> findByMemberId(final String loginId) {
        return memberRepository.findByMemberId(loginId);
    }

    public Optional<Member> findById(final String memberId) {
        return memberRepository.findById(memberId);
    }

}
