package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_Baskets") //Створення таблиці співвідношень "user_id" та "role_id" (Користувачів з їх доступами (ролями))
@IdClass(BasketsPK.class)      //На основі класу BasketsPK.class
public class Baskets {
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "user_id", nullable = false) //Створення  в "tbl_user_roles" колонки "user_id"
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Відношення до певного продукту
    private  Product product;
}
