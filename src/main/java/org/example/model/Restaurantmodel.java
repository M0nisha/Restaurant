package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;

@Entity
@Table (name= "Restaurant")
public class Restaurantmodel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;

    @NotNull( message = "Branch name is required ")
    @Pattern(regexp="^[A-Za-z]$", message = "Enter correct Branch name")
    private String branch;


    @NotNull( message = "Area is required ")
    @Pattern(regexp="^[A-Za-z]$", message = "Enter correct Area")
    private String area;

    @NotNull( message = "PinCode is required ")
    @Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Enter Valid PinCode")
    private String pincode;

    public Restaurantmodel(Integer id, String branch, String area, String pincode) {
        super();
        this.id = id;
        this.branch = branch;
        this.area = area;
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return "RestaurantModel [id=" + id + ", Branch=" + branch + ", Area=" + area + ", Pincode=" + pincode + "]";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.area  = pincode;
    }
    public  Restaurantmodel() {

    }
}
