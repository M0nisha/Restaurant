package org.example.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branchs")
@Getter
@Setter
public class BranchModel  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer branchId;
    private String branch;
    private String area;
    private String pincode;
    @OneToMany(mappedBy = "branchModel")
    private List<MenuModel> menu_items;

}
