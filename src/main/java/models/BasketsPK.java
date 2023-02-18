package models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//  Клас primeri key  базового (первиннного) ключа
@Data
public class BasketsPK implements Serializable {
    private User user;
    private  Product product;
}
