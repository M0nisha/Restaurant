package org.example.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
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
//    @ManyToOne
//    @JoinColumn(name = "branch_model_branch_id")
//    private Branch branchModel;
}
