package org.example.posbackend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @NotNull(message = "Customer Id is Necessary")
    private Long cId;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]{3,50}$",message = "Customer name Pattern added..")
    private String cName;
    @Size(min = 10,max = 100,message ="Address should between 10 to 100 characters")
    private String cAddress;


}
