package program;

import enums.QuestionType;
import models.Question;
import models.QuestionItem;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HiberContext;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //testRole();

        try {
            addQuestion(" Коли вибухнув Чорнобиль? ", QuestionType.RADIO_BUTTON);
            AddQuestionItem(1,"1945", false);
            AddQuestionItem(1,"1986", true);
            AddQuestionItem(1,"1991", false);
        } catch (Exception ex) {
            System.out.println("Виникла помилка "+ex.getMessage());
        }
    }


// ============= Metody ================
        //Метод вводу запитань і варіантів відповдей (Питання, Перелік відповідей)
    private static void addQuestion(String text, enums.QuestionType type) throws SQLException {
        Session context = HiberContext.getSessionFactory().openSession();   // Підключаємось до БД
        Transaction tx = context.beginTransaction();                        // Оголошуємо тип транзакції
        Question q = new Question();                                        // Створюємо нове питання
        q.setText(text);                                                    // Ввід тексту нового питання
        q.setQuestionType(type);                                            // Варіант відповіді
        context.save(q);                                                    // Збереження нового питання
        tx.commit();                                                        // Проводим транзакцію, фіксуємо зміни
        context.close();                                                    // Закриваємо з'єднання з БД
    }

    //Метод вводу запитань і варіантів відповдей (Питання, Відповідь на питання, Вірне/Невірне)
    private static void AddQuestionItem(int questionId, String text,
                                        boolean isTrue ) throws SQLException {
        Session session = HiberContext.getSessionFactory().openSession();   // Підключаємось до БД
        Transaction tx = session.beginTransaction();                        // Оголошуємо тип транзакції
        Question question = new Question();                                 // Створюємо відповідь на питання
        question.setId(questionId);                                         // Ввід тексту відповіді на питання
        QuestionItem qi = new QuestionItem(question, text, isTrue);
        session.save(qi);                                                   // Зберігаємо назву в БД
        tx.commit();
        session.close();                                                    // Закриваємо сесію з нашою БД
    }
    private static void testRole(){
        Scanner in=new Scanner(System.in);
        //   System.out.println("Вкажіть назву ролі");
        //   Role role=new Role();                          //   Створюємо новий об'єкт Role
        //   String name = in.nextLine();                   //   Створюємо об'єкт Role
        //   role.setName(name);                            //   Присвоюємо введену назву об'єкту Role
        Session context = HiberContext.getSessionFactory().openSession();       //   Відкриваємо сесію з нашою БД
        //   context.save(role);                            //   Зберігаємо назву в БД
        //   System.out.println("Role id = "+role.getId()); //   Виводить в консоль id нашої Role в нашій БД

        Query query = context.createQuery("From Role");  //   Створюємо запит до Role нашої БД
        List<Role> roles= query.list();                     //   Отримуємо масив об'єктів Role
        for (Role role : roles)                             //   Виводимо масив об'єктів Role
            System.out.println(role);
        context.close();                                    //   Закриваємо сесію з нашою БД
    }
}
