package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BranchModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Branch name is required ")
    @Pattern(regexp = "^[A-Za-z]$", message = "Enter correct Branch name")
    private String branch;


    @NotNull(message = "Area its required ")
    @Pattern(regexp = "^[A-Za-z]$", message = "Enter correct Area")
    private String area;

    @NotNull(message = "PinCode is required ")
    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Enter Valid PinCode")
    @Column(name = "Pin code")
    private String pincode;

    public BranchModel(Integer id, String branch, String area, String pincode) {
        this.id = id;
        this.branch = branch;
        this.area = area;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "BranchModel [id=" + id + ", Branch=" + branch + ", Area=" + area + ", Pincode=" + pincode + "]";
    }

}
