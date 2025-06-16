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
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Customer group;

    @Column(name = "member_name", nullable = false, length = 100)
    private String memberName;

    @Column(name = "member_id_number", length = 100)
    private String memberIdNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type", length = 30)
    private IdentificationType identificationType;
}
