-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Create_buyers_table
Create table buyers (
    id serial primary key,
    name varchar(128)
);

-- changeset Valentin:Create_carts_table
Create table carts (
    id serial primary key,
    buyer_id integer not null,
    product_id integer not null
);

-- changeset Valentin:Alter_carts_table_fks
ALTER TABLE carts
    ADD CONSTRAINT carts_fk0 FOREIGN KEY (buyer_id) REFERENCES buyers (id);
ALTER TABLE carts
    ADD CONSTRAINT carts_fk1 FOREIGN KEY (product_id) REFERENCES products (id);