-- Brands
INSERT INTO brand (brand_name) VALUES ('Nike');
INSERT INTO brand (brand_name) VALUES ('Octave');
INSERT INTO brand (brand_name) VALUES ('Forever21');
INSERT INTO brand (brand_name) VALUES ('Urban Planet');
INSERT INTO brand (brand_name) VALUES ('Bath and Body Works');
INSERT INTO brand (brand_name) VALUES ('Ubon');

-- Products
INSERT INTO product (name, price, description, brand_id) VALUES ('Air Max 270', 180, 'Nike running shoes', 1);
INSERT INTO product (name, price, description, brand_id) VALUES ('Nike Sportswear Hoodie', 80, 'Comfortable hoodie', 1);
INSERT INTO product (name, price, description, brand_id) VALUES ('Octave Wireless Earbuds', 120, 'Bluetooth earbuds', 2);
INSERT INTO product (name, price, description, brand_id) VALUES ('Forever21 Summer Dress', 40, 'Casual summer dress', 3);
INSERT INTO product (name, price, description, brand_id) VALUES ('Urban Planet Jeans', 60, 'Denim jeans', 4);
INSERT INTO product (name, price, description, brand_id) VALUES ('Bath & Body Works Candle', 25, 'Scented candle', 5);
INSERT INTO product (name, price, description, brand_id) VALUES ('Ubon Wireless Speaker', 70, 'Portable speaker', 6);

-- Orders
INSERT INTO orders_table (user_id, order_date, total_amount) VALUES (2, CURRENT_TIMESTAMP(), 325);
INSERT INTO orders_table (user_id, order_date, total_amount) VALUES (3, CURRENT_TIMESTAMP(), 200);

-- Order Items
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 1, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 4, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 7, 1);

INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 2, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 5, 2);