package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 3.12 Створюємо таблицю з ордерами
@Data
@Entity
@Table(name = "tbl_orderItems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автогенерація Id
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;                         // Дата створення запису
    protected boolean isDelete;                         // Чи видалений
    protected int PriceBuy;                               // Назва продукту
    protected int Count;                               // Назва продукту
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Відношення до певного продукту
    private  Product product;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Відношення до певного ордера
    private  Orders orders;
    public OrderItems(Date dateCreated, boolean isDelete, int priceBuy, int count, Product product, List<Orders> orders) {
        super();
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        PriceBuy = priceBuy;
        Count = count;
        this.product = product;
       // this.orders = orders;
    }
}
