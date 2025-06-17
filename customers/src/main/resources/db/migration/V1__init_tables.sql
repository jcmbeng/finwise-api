CREATE TABLE customers
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    first_name      VARCHAR(100)                NOT NULL,
    last_name       VARCHAR(100)                NOT NULL,
    birth_date      date,
    gender          VARCHAR(20),
    phone_number    VARCHAR(50)                 NOT NULL,
    email           VARCHAR(100),
    address         VARCHAR(255),
    status          VARCHAR(30),
    customer_type   VARCHAR(30)                 NOT NULL,
    is_kyc_verified BOOLEAN                     NOT NULL,
    is_active       BOOLEAN                     NOT NULL,
    is_deleted      BOOLEAN                     NOT NULL,
    created_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at      TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_email UNIQUE (email);

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_phone_number UNIQUE (phone_number);

CREATE TABLE customer_group_members
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    group_id            UUID         NOT NULL,
    member_name         VARCHAR(100) NOT NULL,
    member_id_number    VARCHAR(100),
    identification_type VARCHAR(30),
    CONSTRAINT pk_customer_group_members PRIMARY KEY (id)
);

ALTER TABLE customer_group_members
    ADD CONSTRAINT FK_CUSTOMER_GROUP_MEMBERS_ON_GROUP FOREIGN KEY (group_id) REFERENCES customers (id);


CREATE TABLE customer_documents
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    customer_id     UUID        NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    document_type   VARCHAR(50) NOT NULL,
    document_id     UUID        NOT NULL,
    CONSTRAINT pk_customer_documents PRIMARY KEY (id)
);

ALTER TABLE customer_documents
    ADD CONSTRAINT FK_CUSTOMER_DOCUMENTS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);