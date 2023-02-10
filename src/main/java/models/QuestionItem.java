package models;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_question_items")
public class QuestionItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 500)
    private String text;

    @Column(name = "is_true")
    private boolean isTrue;

    @ManyToOne(fetch = FetchType.LAZY)  // Багато до одного - Відношення колонок таблиці
    @JoinColumn(name = "question_id")   // Відношення колонки таблиці name до question_id
    private Question question;

    public QuestionItem(){}     // Конструктор.

    // Конструктор. До якого питання відноситься відповідь:
    public QuestionItem(Question question, String text, boolean isTrue) {
        this.text= text;
        this.question=question;
        this.isTrue=isTrue;
    }
}