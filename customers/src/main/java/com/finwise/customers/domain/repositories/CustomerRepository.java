package com.finwise.customers.domain.repositories;

import com.finwise.customers.domain.entities.Customer;
import com.finwise.customers.domain.enums.CustomerType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Repository interface for accessing and managing {@link Customer} entities.
 *
 * <p>This interface extends {@link JpaRepository}, providing CRUD operations,
 * pagination, and query support for {@link Customer} entities.</p>
 *
 * <p>Additional custom query methods can be defined here if needed.</p>
 *
 * @author YourName
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> , JpaSpecificationExecutor<Customer> {

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Optional<Customer> findByEmail(String email);

}