package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private String message;
    private boolean succes;
    private Object object;

    public Result(boolean succes, Object object) {
        this.succes = succes;
        this.object = object;
    }

    public Result(String message, boolean succes) {
        this.message = message;
        this.succes = succes;
    }
}
