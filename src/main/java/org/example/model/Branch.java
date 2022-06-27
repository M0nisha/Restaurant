package org.example.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branchName")
@Getter
@Setter
public class Branch {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer branchId;
    private String branchName;

    private String area;
    private String pincode;
    @OneToMany(mappedBy = "branchModel")
    private List<Menu> menu_items;

}
