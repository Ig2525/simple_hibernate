package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 3.12 Створюємо таблицю з продуктами
@Data
@Entity
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автогенерація Id
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;                         // Дата створення запису
    protected boolean isDelete;                         // Чи видалений
    @Column(length = 500,nullable = false)
    private  String name;                               // Назва продукту
    @Column(length = 4000,nullable = false)             // Опис продукту
    private  String description;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Відношення продукту до певної категорії
    private  Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;           // Один до багатьох. Відношення продукту до списку фотографій

    public Product() {
        productImages = new ArrayList<>();      // Створюємо конструктор з списком фото продкта, який буде визиватись командою super(); в основному конструкторі
    }
    public Product(Date dateCreated, boolean isDelete, String name, String description, Category category) {
        super();
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
