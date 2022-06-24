package org.example.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "menu_items")
public class MenuModel
{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer menuId;
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemDescription;
    @ManyToOne
    @JoinColumn(name = "branch_model_branch_id")
    private BranchModel branchModel;
}
