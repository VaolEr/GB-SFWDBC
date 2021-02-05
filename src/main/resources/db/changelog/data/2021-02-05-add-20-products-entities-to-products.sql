-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset Valentin:Add_new_products_to_products_table
insert into products (name , price)
values
    ('Prod1_lesson7', 100),
    ('Prod2_lesson7', 48),
    ('Prod3_lesson7', 22),
    ('Prod4_lesson7', 75),
    ('Prod5_lesson7', 36),
    ('Prod6_lesson7', 150),
    ('Prod7_lesson7', 86),
    ('Prod8_lesson7', 27),
    ('Prod9_lesson7', 73),
    ('Prod10_lesson7', 136),
    ('Prod11_lesson7', 1200),
    ('Prod12_lesson7', 438),
    ('Prod13_lesson7', 252),
    ('Prod14_lesson7', 795),
    ('Prod15_lesson7', 326),
    ('Prod16_lesson7', 1020),
    ('Prod17_lesson7', 4338),
    ('Prod18_lesson7', 242),
    ('Prod19_lesson7', 735),
    ('Prod20_lesson7', 3336);