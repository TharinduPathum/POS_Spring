package org.example.posbackend.repository;

import org.example.posbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    @Query("SELECT MAX(c.cId) FROM Customer c")
    Long findLastCustomerId();
}
