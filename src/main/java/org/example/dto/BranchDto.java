package org.example.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class BranchDto {
    @NotEmpty
    @NotBlank
    @NotNull(message = "BranchName is required")
    private String branchName;
    @NotEmpty
    @NotBlank
    @NotNull(message = "Area is required ")
    private String area;
    @NotEmpty
    @NotBlank
    @NotNull(message = "PinCode is required ")
    private String pincode;
}