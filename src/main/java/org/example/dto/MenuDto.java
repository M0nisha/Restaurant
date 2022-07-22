package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@Getter
@Setter
public class MenuDto {

 @NotEmpty
    @NotBlank
    @NotNull(message = " itemName is required ")
   @Pattern(regexp = "^[a-zA-Z/d]+$")
    private String itemName;
    @NotNull
   private Integer itemPrice;
    @NotNull
    private Integer itemQuantity;

   @NotEmpty
   @NotBlank
   @Pattern(regexp="^[a-zA-Z]*$",message="Description must be alphabet")
   @NotNull(message = "itemDescription is required")
    private String itemDescription;
}
