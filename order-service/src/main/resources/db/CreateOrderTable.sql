
SELECT 'CREATE DATABASE orderservice'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'orderservice');

CREATE TABLE IF NOT EXISTS order_line_items(
    id uuid primary key,
    skuCode text,
    price bigint,
    quantity int
);

CREATE TABLE IF NOT EXISTS orders_table(
    id uuid primary key  ,
    order_number varchar(100),
    order_line_items_id uuid references order_line_items(id)
);