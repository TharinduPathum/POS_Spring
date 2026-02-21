package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OderDeatilesDto {

    private String oderDeatilesId;
    @NotBlank
    private String oderId;
    @NotBlank
    private String itemId;
    @NotBlank
    private String qty;
    @NotBlank
    private String totlePrice;
}
