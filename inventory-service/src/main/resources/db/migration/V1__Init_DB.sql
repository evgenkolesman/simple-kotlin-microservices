

SELECT 'CREATE DATABASE orderservice'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'orderservice');

CREATE TABLE IF NOT EXISTS t_inventory
(
    id       bigint PRIMARY KEY,
    sku_code  text,
    quantity INT
);



