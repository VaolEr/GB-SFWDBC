-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Create_products_table
CREATE TABLE products
(
    -- SERIAL type "id" is BIGINT
    id          integer UNSIGNED NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255)     NOT NULL,
    cost        integer UNSIGNED NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
);