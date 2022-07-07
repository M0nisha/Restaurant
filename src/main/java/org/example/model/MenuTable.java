package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_table")
@Getter
@Setter
public class MenuTable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String description;
    private String something;

}
