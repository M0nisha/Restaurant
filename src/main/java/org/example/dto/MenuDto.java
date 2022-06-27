package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class MenuDto {

    @NotNull
    private String itemName;
    @NotNull
    private String itemPrice;
    @NotNull
    private String itemQuantity;
    @NotNull
    private String itemDescription;
}
