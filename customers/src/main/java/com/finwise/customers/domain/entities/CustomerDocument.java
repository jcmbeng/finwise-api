package com.finwise.customers.domain.entities;

import com.finwise.customers.domain.enums.IdentificationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

/**
 * Represents a member of a group customer.
 *
 * @author Jean-Claude MBENG
 */
@Entity
@Table(name = "customer_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDocument {

    /**
     * Unique identifier for the document.
     */
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    /**
     * The UUID of the associated customer.
     * This allows for a loosely coupled relationship between microservices.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /**
     * Eg. Passeport number
     */
    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    /**
     * Type of identification represented by the document.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false, length = 50)
    private IdentificationType documentType;

    /**
     * Name of the file or document (e.g. "passport.png").
     */
    @Column(name = "document_id", nullable = false)
    private UUID documentId;


}
