package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "menu_items")
public class Menu
{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer menuId;
    private String itemName;
    private Integer itemPrice;
    private Integer itemQuantity;
    private String itemDescription;
    private Boolean isActive=true;

}
