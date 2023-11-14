package cookeryket_sb.cookeryket_sb.entity;

import cookeryket_sb.cookeryket_sb.dto.UserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(unique = true)
    private String userId;

    @Column
    private String userPw;

    @Column
    private String userName;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String userAddress;

    public static UserEntity toMemberEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserPw(userDTO.getUserPw());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUserAddress(userDTO.getUserAddress());

        return userEntity;
    }
}
