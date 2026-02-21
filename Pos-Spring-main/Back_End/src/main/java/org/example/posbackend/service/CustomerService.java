package org.example.posbackend.service;

import org.example.posbackend.dto.CustomerDTO;
import org.example.posbackend.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);

    public void updateCustormer(CustomerDTO customerDTO);

    public List<CustomerDTO> getAll();

    public void deleteCustomer(String id);

    public Long getLastId();

}
