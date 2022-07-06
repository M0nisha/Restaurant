package org.example.model;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branchName")
@Getter
@Setter

@NoArgsConstructor
public class Branch {
    public Branch(Integer branchId, String branchName, String area, String pincode) {
        super();
        this.branchId = branchId;
        this.branchName = branchName;
        this.area = area;
        this.pincode = pincode;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer branchId;
    private String branchName;
    private String area;
    private String pincode;
//    @OneToMany(mappedBy = "branchModel")
//    private List<Menu> menu_items;
}