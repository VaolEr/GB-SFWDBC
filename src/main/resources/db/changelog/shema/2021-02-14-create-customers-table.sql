-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Create_customers_table
Create table customers (
    id varchar(128) primary key,
    first_name varchar(128),
    last_name varchar(128),
    city varchar(128)
);