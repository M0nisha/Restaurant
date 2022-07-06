package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
public class BranchMenuDto {
   @NotNull
   @NotEmpty
   @NotBlank
   private  String branchName;
    @NotEmpty
    @NotBlank
    @NotNull
    private String area;
   @NotNull
   @NotEmpty
   @NotBlank
   private String pincode;
   @NotNull @NotEmpty @NotBlank
   private List<MenuDto> menuDto;




}



