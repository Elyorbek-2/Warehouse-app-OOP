package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeProduct {
    private Integer id;
    private Product product;
    private double price;
    private Timestamp timestamp;
}
