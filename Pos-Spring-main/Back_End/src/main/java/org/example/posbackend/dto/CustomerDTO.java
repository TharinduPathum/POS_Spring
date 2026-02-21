package org.example.posbackend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {
    @NotNull(message = "Customer Id is Necessary")
    private Long cId;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]{3,50}$",message = "Customer name Pattern added..")
    private String cName;
    @Size(min = 10,max = 100,message ="Address should between 10 to 100 characters")
    private String cAddress;

    public CustomerDTO(Long cId, String cName, String cAddress) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
    }
    public CustomerDTO() {

    }

    public Long getCId() {
        return cId;
    }

    public String getCname() {
        return cName;
    }

    public String getCaddress() {
        return cAddress;
    }


    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAddress='" + cAddress + '\'' +
                '}';
    }


}
