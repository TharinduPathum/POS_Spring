package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemDto {

    @NotNull(message = "Item Id Cannot be Null ")
    private Long itemId;
    @NotBlank
    private String itemName;
    @NotNull(message = "Item qty Cannot be Null")
    private String qty;
    @NotNull(message = "Item  price Cannot be Null")
    private String price;
}
