
SELECT 'CREATE DATABASE orderservice'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'orderservice');

CREATE TABLE IF NOT EXISTS order_line_items(
    id uuid primary key,
    skuCode text,
    price bigint,
    quantity int,
    order_id uuid

);

CREATE TABLE IF NOT EXISTS orders_table(
    id uuid primary key  ,
    order_number varchar(100)
);


alter table order_line_items
    add foreign key (order_id) references orders_table(id);