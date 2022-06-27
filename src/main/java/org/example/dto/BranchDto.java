package org.example.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class BranchDto {
    @NotNull(message = "Branch name is required ")
    private String branchName;
    @NotNull(message = "Area is required ")
    private String area;
    @NotNull(message = "PinCode is required ")
    private String pincode;



}