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
public class MenuDto {


    @NotEmpty
    @NotBlank
    @NotNull(message = " itemName is required ")
    private String itemName;
    @NotNull(message = "itemPrice is required")
    private Integer itemPrice;
    @NotNull(message="itemQuantity is required")
    private Integer itemQuantity;
    @NotNull(message = "itemDescription is required")
    private String itemDescription;
}
