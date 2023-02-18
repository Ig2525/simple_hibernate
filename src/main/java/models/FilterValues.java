package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 4.3 Створюємо таблицю з значеннями фільтрів
@Data
@Entity
@Table(name = "tblFilterValues")
public class FilterValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автогенерація Id
    protected int id;
    protected boolean isDelete;                         // Чи видалений
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;                         // Дата створення запису
    @Column(length = 500,nullable = false)
    private  String name;                               // Назва фільтра значень

    @OneToMany(mappedBy = "filterValues")           // 3.3 Прив'язка "один до багатьох" до масиву значень можливих ролей користувача колонка "user" в таблиці "tbl_user_roles" класу "UserRoles"
    private List<Filters> filters;

   public FilterValues() {
        filters=new ArrayList<>();
   }

    public FilterValues(boolean isDelete, Date dateCreated, String name) {
        super();
        this.isDelete = isDelete;
        this.dateCreated = dateCreated;
        this.name = name;
    }
}
