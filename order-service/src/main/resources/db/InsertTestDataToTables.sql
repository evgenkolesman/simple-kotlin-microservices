-- CREATE TABLE IF NOT EXISTS order_line_items(
--                                                id uuid primary key,
--                                                skuCode text,
--                                                price bigint,
--                                                quantity int,
--                                                order_id uuid
--
-- );


WITH uuids AS  (
SELECT gen_random_uuid() as u1,
gen_random_uuid() as u2,
gen_random_uuid() as u3,
gen_random_uuid() as u4),
orders as (INSERT INTO orders_table VALUES (
                                 (SELECT u1 FROM uuids), 'NUMBER1'),
                                 ((SELECT u2 FROM uuids), 'NUMBER2'),
                                 ((SELECT u3 FROM uuids), 'NUMBER3'),
                                 ((SELECT u4 FROM uuids), 'NUMBER4') ON CONFLICT DO NOTHING)
INSERT INTO order_line_items
VALUES
      (gen_random_uuid(),  'SKUCODE1', 100 ::bigint, 10, (SELECT u1 FROM uuids)),
      (gen_random_uuid(),  'SKUCODE2', 200 ::bigint, 20, (SELECT u2 FROM uuids)),
      (gen_random_uuid(),  'SKUCODE3', 300 ::bigint, 30, (SELECT u3 FROM uuids)),
      (gen_random_uuid(),  'SKUCODE4', 400 ::bigint, 40, (SELECT u4 FROM uuids)) ON CONFLICT DO NOTHING;

