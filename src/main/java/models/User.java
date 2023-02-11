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

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    public User() {
        userRoles=new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String phone, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}



/*
package models;

import enums.QuestionType;
import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_question")                                 //Назва таблиці, яка створиться в БД
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Автоінкремент по ключу коли додається новий запис
    private int id;
    @Column(name="text", nullable = false, length = 500)    //Настройки для колонки таблиці
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name="question_type")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)  //Привя'зка відповідей до своїх питань
    private List<QuestionItem> questionItems;
}
* */