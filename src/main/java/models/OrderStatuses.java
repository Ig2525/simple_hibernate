package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_orderStatuses")
public class OrderStatuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500,nullable = false)
    protected String name;
    public OrderStatuses(Date dateCreated, boolean isDelete, String name) {
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.name = name;
    }
}
