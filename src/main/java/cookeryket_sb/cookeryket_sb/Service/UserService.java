package cookeryket_sb.cookeryket_sb.Service;

import cookeryket_sb.cookeryket_sb.Repository.UserRepository;
import cookeryket_sb.cookeryket_sb.dto.UserDTO;
import cookeryket_sb.cookeryket_sb.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toMemberEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO login(UserDTO userDTO) { // entity 객체는 service에서만
        Optional<UserEntity> byEmail = userRepository.findByEmail(userDTO.getEmail());
        if (byEmail.isPresent()) {
            UserEntity userEntity = byEmail.get();
            if (userEntity.getUserPw().equals(userDTO.getUserPw())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 조회 결과가 없다
            return null;
        }
    }
}
