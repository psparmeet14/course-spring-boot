package com.parmeet.customer.data;

import com.parmeet.customer.data.entities.Customer;
import com.parmeet.customer.data.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerdataApplicationTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setEmail("john@gmail.com");
        repo.save(customer);
    }

    @Test
    void testFindCustomerById() {
        Customer customer = repo.findById(1l).get();
        System.out.println(customer);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = repo.findById(1l).get();
        customer.setEmail("john123@gmail.com");
        repo.save(customer);
    }

    @Test
    void testDeleteCustomer() {
        repo.deleteById(1l);
    }
}
