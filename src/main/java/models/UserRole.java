package models;
import lombok.Data;
import javax.persistence.*;
// 3.2 Клас UserRole.class створює таблицю співвідношень Користувачів з їх доступами (ролями)
@Data
@Entity
@Table(name = "tbl_user_roles") //Створення таблиці співвідношень "user_id" та "role_id" (Користувачів з їх доступами (ролями))
@IdClass(UserRolePK.class)      //На основі класу UserRolePK.class
public class UserRole {
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "user_id", nullable = false) //Створення  в "tbl_user_roles" колонки "user_id"
    private User user;
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "role_id", nullable = false) //Створення  в "tbl_user_roles" колонки "role_id"
    private Role role;


}
