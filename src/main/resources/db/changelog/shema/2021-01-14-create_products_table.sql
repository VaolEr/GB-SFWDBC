-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Create_products_table
Create table products (
    id serial primary key,
    name varchar(128),
    price integer
);