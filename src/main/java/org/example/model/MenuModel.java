package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter @Setter
public class MenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String itemName;
    private String itemPrice;
    private String itemQuality;
    private String itemDescription;

    public MenuModel(String itemName, String itemPrice, String itemQuality, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuality = itemQuality;
        this.itemDescription = itemDescription;
    }
}
