package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OderDto {
    @NotBlank
    private String oderId;

    @NotBlank
    private String custormerId;
    @NotBlank
    private String date;
}
