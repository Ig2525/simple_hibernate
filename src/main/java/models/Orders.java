package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_Order")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «багато до одного».
    @JoinColumn(name = "user_id", nullable = false) //Створення колонки "user_id"
    private User user;
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «багато до одного».
    @JoinColumn(name = "orderStatuses_id", nullable = false) //Створення колонки "user_id"
    private OrderStatuses orderStatuses;
    public Orders(Date dateCreated, boolean isDelete, User user, OrderStatuses orderStatuses) {
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.user = user;
        this.orderStatuses = orderStatuses;
    }
}
