package com.finwise.customers.domain.enums;

/**
 * Enum representing the supported types of identification documents
 * for customers in the FinWise Core Banking System.
 * <p>
 * This is useful for verifying customer identity as part of the KYC process.
 */
public enum IdentificationType {

    /**
     * National Identity Card
     */
    NATIONAL_ID,

    /**
     * Passport
     */
    PASSPORT,

    /**
     * Driver’s License
     */
    DRIVING_LICENSE,

    /**
     * Voter Card
     */
    VOTER_ID,

    /**
     * Residence Permit or Foreigner ID
     */
    RESIDENCE_PERMIT,

    // Group / Organization Identification Types
    REGISTRATION_CERTIFICATE,  // Official registration or incorporation certificate
    TAX_IDENTIFICATION_NUMBER, // Tax ID for companies or associations
    BUSINESS_LICENSE,          // Business operating license
    ASSOCIATION_CARD,           // Membership or association card for groups

    /**
     * Other types of identification not explicitly listed
     */
    OTHER
}
