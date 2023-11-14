package cookeryket_sb.cookeryket_sb.dto;

import cookeryket_sb.cookeryket_sb.entity.UserEntity;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String phoneNumber;
    private String email;
    private String userAddress;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserPw(userEntity.getUserPw());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setUserAddress(userEntity.getUserAddress());

        return userDTO;
    }

}
