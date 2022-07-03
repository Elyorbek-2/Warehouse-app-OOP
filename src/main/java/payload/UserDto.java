package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String prepassword;
    private Integer addressId;

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
