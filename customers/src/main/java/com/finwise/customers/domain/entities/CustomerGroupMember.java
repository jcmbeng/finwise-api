package com.finwise.customers.domain.entities;

import com.finwise.customers.domain.enums.IdentificationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

/**
 * Represents a member of a group customer.
 */
@Entity
@Table(name = "customer_group_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerGroupMember {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Customer group;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_id_number")
    private String identificationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type")
    private IdentificationType identificationType;
}
