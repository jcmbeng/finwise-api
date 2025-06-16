package com.finwise.customers.domain.repositories;

import com.finwise.customers.domain.entities.Customer;
import com.finwise.customers.domain.enums.CustomerType;
import com.finwise.customers.domain.enums.IdentificationType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldFindCustomerByPhoneNumber() {

        // Given
        Customer customer =  Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.of(1990, 1, 1))
                .phoneNumber("0123456789")
                .email("john.doe@finwise.com")
                .documents(new ArrayList<>())
                .isActive(true)
                .isDeleted(false)
                .isKycVerified(true)
                .customerType(CustomerType.INDIVIDUAL)
                .build();

        customerRepository.save(customer);

        //When
        Optional<Customer> optionalCustomer = customerRepository.findByPhoneNumber("0123456789");

        //Then
        assertTrue(optionalCustomer.isPresent());
        assertThat(optionalCustomer.get().getFirstName()).isEqualTo("John");
        assertThat(optionalCustomer.get().getPhoneNumber()).isEqualTo("0123456789");

    }
    
    @Test
    void shouldNotFindCustomerByEmail() {
        // Given
        Customer customer =  Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.of(1990, 1, 1))
                .phoneNumber("0123456789")
                .email("john.doe@finwise.com")
                .documents(new ArrayList<>())
                .isActive(true)
                .isDeleted(false)
                .isKycVerified(true)
                .customerType(CustomerType.INDIVIDUAL)
                .build();

        customerRepository.save(customer);

        //When
        Optional<Customer> optionalCustomer = customerRepository.findByEmail("john.doe@finwise.com");

        //Then
        assertTrue(optionalCustomer.isPresent());
        assertThat(optionalCustomer.get().getFirstName()).isEqualTo("John");
        assertThat(optionalCustomer.get().getEmail()).isEqualTo("john.doe@finwise.com");
    }

}