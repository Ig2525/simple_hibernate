package models;
import lombok.Data;
import java.io.Serializable;

// Клас primeri key  базового (первиннного) ключа
@Data
public class FilterNameGroupsPK implements Serializable {
    private FilterNames filterNames;
    private FilterValues filterValues;
}
