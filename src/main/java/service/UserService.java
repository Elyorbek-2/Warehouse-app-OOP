package service;

import entity.Address;
import entity.BlockUser;
import entity.Role;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payload.Result;
import payload.UserDto;
import repository.UserRepository;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        // userga addressni davom ettirish kerak
        return null;
    }

    public boolean equalsUser(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword()))
                return true;
        }
        return false;
    }
    public boolean equalsDirector(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword())&&user.getRole().equals(Role.DIRECTOR))
                return true;
        }
        return false;
    }
    public boolean equalsDriver(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword())&&user.getRole().equals(Role.DRIVER))
                return true;
        }
        return false;
    }
    public boolean equalsVendor(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword())&&user.getRole().equals(Role.VENDOR))
                return true;
        }
        return false;
    }
    public boolean equalsWorker(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword())&&user.getRole().equals(Role.WORKER))
                return true;
        }
        return false;
    }
    public boolean equalsUserRole(UserDto userDto) {
        Set<User> userSet = userRepository.getUserSet();
        for (User user : userSet) {
            if (user.getEmail().equals(userDto.getEmail())&&user.getPassword().equals(userDto.getPassword())&&user.getRole().equals(Role.WORKER))
                return true;
        }
        return false;
    }

    public void blockUser(User user) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plus(5, ChronoUnit.HOURS);
        BlockUser blockUser = new BlockUser(user, start, end, true);
    }

    public  boolean checkDuration(User user) {
        //BlockUser blockUser = repository.findByUserId(user.getId());
        BlockUser blockUser = new BlockUser();
        return blockUser.getUnblockedDate().isAfter(LocalDateTime.now());
    }

    public void unblockUser(User user) {

    }
}
