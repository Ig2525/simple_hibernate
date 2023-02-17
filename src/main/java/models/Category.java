package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 3.9 Створюємо таблицю з категоріями
@Data
@Entity
@Table(name = "tbl_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500,nullable = false)
    private  String name;
    @Column(length = 200)
    private  String image;

    @OneToMany(mappedBy = "category") // 3.10 Прив'язка "один до багатьох" до масиву значень "category"
    private List<Product> products;

    public Category() {
        products=new ArrayList<>();
    }  // 3.11 Створюємо конструктор з списком, який буде визиватись командою super(); в основному конструкторі

        public Category(String name, String image, Date dateCrete, boolean isDelete){
        super();
        this.name=name;
        this.image=image;
        this.dateCreated=dateCrete;
        this.isDelete=isDelete;
    }
}
