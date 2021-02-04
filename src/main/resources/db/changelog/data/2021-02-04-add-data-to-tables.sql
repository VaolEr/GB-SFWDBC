-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Add_new_products_to_products_table
insert into products (name , price)
    values
        ('Prod1', 100),
        ('Prod2', 48),
        ('Prod3', 22),
        ('Prod4', 75),
        ('Prod5', 36);

-- changeset Valentin:Add_new_buyers_to_buyers_table
insert into buyers (name)
    values
        ('Anton'),
        ('Boris'),
        ('Victor');

-- changeset Valentin:Add_new_carts_to_carts_table
insert into carts (buyer_id, product_id)
    values
        (1,1),
        (1,2),
        (1,3),
        (2,4),
        (2,4),
        (3,5);