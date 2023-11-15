package cookeryket_sb.cookeryket_sb.controller;

import cookeryket_sb.cookeryket_sb.entity.Member;
import cookeryket_sb.cookeryket_sb.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public void signUp(@RequestBody final Member member) {
        memberService.join(member);
    }

    // 로그인
    @GetMapping("/login/{id}")
    public Member login(@PathVariable("id") final String id, @RequestParam("password") final String password) {
        Optional<Member> member = memberService.findByMemberId(id);
        if (member.isPresent()) {
            if (member.get().getMemberPw().equals(password)) {
                log.info("login success!");
                return member.get();
            } else {
                log.info("wrong password!");
                return null;
            }
        } else {
            log.info("wrong id!");
            return null;
        }
    }

    @GetMapping("/list")
    public List<Member> memberList () {
        return memberService.memberList();
    }

    //회원 리스트
    @GetMapping("/{id}")
    public Member findMember (@PathVariable("id") String memberId){
        Optional<Member> optionalMember = memberService.findById(memberId);
        if (optionalMember.isPresent()) {
            return optionalMember.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
    }
}
