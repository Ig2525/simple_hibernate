package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filters") //Створення таблиці співвідношень "filter_named_id", "filter_value_id" i "product_id"
@IdClass(FiltersPK.class)      //На основі класу FiltersPK.class
public class Filters {
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "filterNames_id", nullable = false) //Створення  в "tbl_filters" колонки "filterNames_id"
    private FilterNames filterNames;
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "filterValues_id", nullable = false) //Створення  в "tbl_filters" колонки "filterValues"
    private FilterValues filterValues;
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "product_id", nullable = false) // Відношення фільтрів до певного продукту
    private  Product product;
}
