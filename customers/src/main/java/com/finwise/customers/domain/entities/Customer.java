package com.finwise.customers.domain.entities;

import com.finwise.customers.domain.enums.CustomerStatus;
import com.finwise.customers.domain.enums.CustomerType;
import com.finwise.customers.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Represents a customer in the FinWise Core Banking System.
 * <p>
 * Each customer can hold one or more accounts and is identified uniquely using a UUID.
 *
 * @author Jean-Claude MBENG
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    /**
     * The unique identifier for the customer.
     * Generated automatically as UUID v4.
     */
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    /**
     * Customer's first name.
     */
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    /**
     * Customer's last name.
     */
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    /**
     * List of documents linked to this customer.
     * CustomerDocument is stored in another service/database.
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CustomerDocument> documents;

    /**
     * Customer's date of birth, can be used for creation the date of the group (association, NGO, company...).
     */
    @Column(name = "birth_date", length = 4)
    private LocalDate birthDate;

    /**
     * Customer's gender.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 20)
    private Gender gender;

    /**
     * Mobile phone number used for contact and mobile money.
     */
    @Column(name = "phone_number", nullable = false, unique = true, length = 50)
    private String phoneNumber;

    /**
     * Customer's email address.
     */
    @Column(name = "email", unique = true, length = 100)
    private String email;

    /**
     * Residential address of the customer.
     */
    @Column(name = "address")
    private String address;

    /**
     * Status of the customer (ACTIVE, INACTIVE, BLOCKED).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30)
    private CustomerStatus status;

    /**
     * Type of the customer: INDIVIDUAL or GROUP.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type", nullable = false , length = 30)
    private CustomerType customerType;

    /**
     * Whether the KYC (Know Your Customer) verification has been completed.
     */
    @Column(name = "is_kyc_verified", nullable = false)
    private boolean isKycVerified = false;

    /**
     * Whether this customer record is currently active.
     */
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    /**
     * Whether this customer record has been soft-deleted.
     */
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    /**
     * Timestamp when this customer was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp of the most recent update to this record.
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Members of the group (only applicable if customerType = GROUP).
     */
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CustomerGroupMember> groupMembers;

    /**
     * Automatically sets creation and update timestamps before persisting.
     */
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    /**
     * Automatically updates the updatedAt timestamp before update.
     */
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
