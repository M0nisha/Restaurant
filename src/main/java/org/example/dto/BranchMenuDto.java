package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
public class BranchMenuDto {
   @NotNull
    private  String branchName;
   @NotNull
    private String area;
   @NotNull
    private String pincode;
   @NotNull
    private List<MenuDto> menuDto;




}



