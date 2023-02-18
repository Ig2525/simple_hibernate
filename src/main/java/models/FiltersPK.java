package models;
import lombok.Data;
import java.io.Serializable;

//  Клас primeri key  базового (первиннного) ключа Фільтрів
@Data
public class FiltersPK implements Serializable {
    private FilterNames filterNames;
    private FilterValues filterValues;
    private  Product product;
}
