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