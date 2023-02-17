package models;
import lombok.Data;
import java.io.Serializable;
//  3.1 Клас primeri key  базового (первиннного) ключа
@Data
public class UserRolePK implements Serializable {
    private User user;
    private Role role;

}
