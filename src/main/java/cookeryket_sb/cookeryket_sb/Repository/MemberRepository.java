package cookeryket_sb.cookeryket_sb.Repository;

import cookeryket_sb.cookeryket_sb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(final String loginId);
}
