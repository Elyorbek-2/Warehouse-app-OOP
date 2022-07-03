package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Integer id;
    private String name;
    private Timestamp createdProductDateTime;
    private Measurement measurement;
    private Timestamp expireDate;
    private Category category;
    private Double price;

}
