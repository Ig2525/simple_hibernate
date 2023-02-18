package models;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tbl_users")                                 //Назва таблиці, яка створиться в БД
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Автоінкремент по ключу коли додається новий запис
    private int id;
    //protected boolean isDelete;
    // @Temporal(TemporalType.TIMESTAMP)
    //protected Date dateCreated;
    @Column(length = 100,nullable = false)
    private String firstName;
    @Column(length = 100,nullable = false)
    private String lastName;
    @Column(length = 200,nullable = false)
    private String email;
    @Column(length = 20,nullable = false)
    private String phone;
    @Column(length = 100,nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")           // 3.3 Прив'язка "один до багатьох" до масиву значень можливих ролей користувача колонка "user" в таблиці "tbl_user_roles" класу "UserRoles"
    private List<UserRole> userRoles;
    public User() {
        userRoles=new ArrayList<>();        // 3.4 Створюємо конструктор з списком, який буде визиватись командою super(); в основному конструкторі
    }

    public User(String firstName, String lastName, String email, String phone, String password) {
        super();                            // 3.5 Визиває конструктор по замовчуванню і проініціалізує змінну userRoles
        //this.dateCreated=dateCrete;
        //this.isDelete=isDelete;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

}