package models;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tbl_roles") //Назва таблиці, яка створиться в БД
public class Role {
    @Id //Первинний ключ
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Автоінкремент по ключу коли додається новий запис
    private int id;
    @Column(length = 255,nullable = false)              //Настройки для колонки таблиці
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role() {
        userRoles=new ArrayList<>();
    }

}
