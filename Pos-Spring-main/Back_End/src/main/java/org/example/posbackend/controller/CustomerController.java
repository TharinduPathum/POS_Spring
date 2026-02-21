package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.Util2.APIRespons;
import org.example.posbackend.dto.CustomerDTO;
import org.example.posbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseEntity<APIRespons<String>> saveCustomer(@RequestBody  @Valid CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(new APIRespons<>(201,"Saved Customer Successfully",null), HttpStatus.CREATED);

    }

    @PutMapping("update")
    public ResponseEntity<APIRespons<String>>  updateCustomer(@RequestBody  @Valid CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        System.out.println(customerDTO.getCId());
        System.out.println(customerDTO.getCaddress());
        System.out.println(customerDTO.getCname());
        customerService.updateCustormer(customerDTO);
        return new ResponseEntity<>(new APIRespons<>(200,"Updated Successfully",null), HttpStatus.CREATED);

    }


    @GetMapping("getAll")
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customerList = customerService.getAll();
        return customerList;
    }

    @DeleteMapping("delete")
    public ResponseEntity<APIRespons<String>>  deleteMethod(@RequestBody @Valid  CustomerDTO customerDTO) {
        customerService.deleteCustomer(String.valueOf(customerDTO.getCId()));
        return new ResponseEntity<>(new APIRespons<>(204,null,null), HttpStatus.CREATED);

    }

    @GetMapping("getLastCustomerId")
    public String getLastCustomerId() {
        java.lang.Long lastIdIs = customerService.getLastId();
        String lastId = String.valueOf(lastIdIs);
        return lastId;
    }


}
