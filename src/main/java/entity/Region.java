package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Region {
    private String name;
    private Country country;
}
