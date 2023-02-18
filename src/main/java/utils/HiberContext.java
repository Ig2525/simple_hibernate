package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HiberContext {
    private static SessionFactory sessionFactory; //Об'єкт роботи з БД, контекст підключення до БД
    private HiberContext(){}
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){

            //Читаємо конфігурацію
            Configuration configuration=new Configuration().configure();

            configuration.addAnnotatedClass(Role.class);        // Добавляємо клас Role в анотацію для її створення в БД
            configuration.addAnnotatedClass(Question.class);    // Добавляємо клас Question в анотацію для її створення в БД
            configuration.addAnnotatedClass(QuestionItem.class);// Добавляємо клас QuestionItem в анотацію для її створення в БД
            configuration.addAnnotatedClass(User.class);        // Добавляємо клас User в анотацію для її створення в БД
            configuration.addAnnotatedClass(UserRole.class);    // Добавляємо клас UserRole в анотацію для її створення в БД
            configuration.addAnnotatedClass(Category.class);    // Добавляємо клас Category в анотацію для її створення в БД
            configuration.addAnnotatedClass(Product.class);     // Добавляємо клас Product в анотацію для її створення в БД
            configuration.addAnnotatedClass(ProductImage.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(FilterNames.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(FilterValues.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(Filters.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(FilterNameGroups.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(Baskets.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(Orders.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(OrderItems.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД
            configuration.addAnnotatedClass(OrderStatuses.class);    // Добавляємо клас ProductImage в анотацію для її створення в БД

            //Реєструємо сервіс на основі нашого конфіга
            StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            //Створюємо контекст до БД
            sessionFactory= configuration.buildSessionFactory(builder.build());
        }
        return  sessionFactory;
    }
}
