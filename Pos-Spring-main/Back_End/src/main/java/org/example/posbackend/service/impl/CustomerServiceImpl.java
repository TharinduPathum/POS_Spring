package org.example.posbackend.service.impl;

import jakarta.persistence.EntityExistsException;
import org.example.posbackend.Exceptions.CustomException;
import org.example.posbackend.dto.CustomerDTO;
import org.example.posbackend.entity.Customer;
import org.example.posbackend.repository.CustomerRepository;
import org.example.posbackend.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        Optional<Customer> customer1 = customerRepository.findById(String.valueOf(customerDTO.getCId()));

        if (customer1.isPresent()) {

            throw new EntityExistsException("Customer already exists!");

        } else {
            customerRepository.save(customer);

        }


    }

    @Override
    public void updateCustormer(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Optional<Customer> customer1 = customerRepository.findById(String.valueOf(customerDTO.getCId()));

        if (customer1.isPresent()) {

            customerRepository.save(customer);

        } else {

            throw new NullPointerException("Customer not available...!");
        }

    }


    @Override
    public List<CustomerDTO> getAll() {

        List<CustomerDTO> customerDTOList = new ArrayList<>();
        java.util.List<Customer> customerslist = customerRepository.findAll();


        for (int i = 0; i < customerslist.size(); i++) {
            CustomerDTO dto = modelMapper.map(customerslist.get(i), CustomerDTO.class);
            customerDTOList.add(dto);
        }

        if (customerDTOList.isEmpty()) {

            throw new NullPointerException("customers are not Available yet...");

        }

        return customerDTOList;
    }


    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> customer1 = customerRepository.findById(id);

        if (customer1.isPresent()) {

            customerRepository.deleteById(id);

        } else {

            throw new NullPointerException("Customer not available to Delete...!");
        }





    }

    @Override
    public Long getLastId() {
        Long lastId = customerRepository.findLastCustomerId();

        if (lastId == null) {
            long id = 0;
            return id;
        } else {
            return lastId;
        }
    }


}
