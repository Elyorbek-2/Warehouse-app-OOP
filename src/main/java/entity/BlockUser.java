package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockUser {
    public final Long ID = (long) ((Math.random() * 9999) + 1);
    private User user;
    private LocalDateTime blockedDate;        //  blocked date
    private LocalDateTime unblockedDate;        // unblocked date
    private boolean active;                     // true - blocked, false - unblocked

}
