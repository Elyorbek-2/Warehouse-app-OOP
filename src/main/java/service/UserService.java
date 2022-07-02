package service;

import entity.Address;
import entity.Role;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payload.Result;
import payload.UserDto;
import repository.UserRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserService {
    static UserRepository userRepository=new UserRepository();

    public Result saveUser(UserDto userDto) {
        if (!userDto.getPassword().equals(userDto.getPrepassword()))
            return new Result(false,new Exception("Parol kiritishda xatolik"));
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail()))
                return new Result("Bunday emailli foydalanuvchi ro'yxatdan o'tgan",false);
        }
        User user=new User();
        user.setId(userRepository.getUserSet().size()+1);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        Date date=new Date();
        long dateTime = date.getTime();
        user.setCreateUser(new Timestamp(dateTime));
        user.setRole(Role.USER);
        Address address=new Address();
    }
}
