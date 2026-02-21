package org.example.posbackend.dto.Util;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.posbackend.dto.OderDeatilesDto;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlaceOderDto {
    @NotBlank
    private String oderId;
    @NotBlank
    private String custormerId;
    @NotBlank
    private List<OderDeatilesDto> oderDeatilesList;
    private String date;
}
