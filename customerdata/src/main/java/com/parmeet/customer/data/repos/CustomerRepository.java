package com.parmeet.customer.data.repos;

import com.parmeet.customer.data.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
