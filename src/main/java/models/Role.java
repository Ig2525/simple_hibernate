package models;
import lombok.Data;
import lombok.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tbl_roles") //Назва таблиці, яка створиться в БД
public class Role {
    @Id //Первинний ключ
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Автоінкремент по ключу коли додається новий запис
    private int id;
    //protected boolean isDelete;
    // @Temporal(TemporalType.TIMESTAMP)
    //protected Date dateCreated;
    @Column(length = 255,nullable = false)              //Настройки для колонки таблиці
    private String name;

    @OneToMany(mappedBy = "role")   // 3.6 Прив'язка "один до багатьох" до масиву значень можливих ролей користувача колонка "role" в таблиці "tbl_user_roles" класу "UserRoles"
    private List<UserRole> userRoles;
    public Role() {
        userRoles=new ArrayList<>(); // 3.7 Створюємо конструктор з списком
    }
}
