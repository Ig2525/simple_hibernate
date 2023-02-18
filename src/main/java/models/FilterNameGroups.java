package models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tbl_filter_names_groups") //Створення таблиці співвідношень "named_id" та "filter_id"
@IdClass(FilterNameGroupsPK.class)      //На основі класу FilterNameGroupsPK.class
public class FilterNameGroups {
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "filterNames_id", nullable = false) //Створення  в "tbl_filter_names_groups" колонки "filterNames_id"
    private FilterNames filterNames;
    @Id
    @ManyToOne                  // Асоціація ManyToOne відображає зв’язок таблиці «один до багатьох».
    @JoinColumn(name = "filterValues_id", nullable = false) //Створення  в "tbl_filter_names_groups" колонки "filterValues"
    private FilterValues filterValues;


}
