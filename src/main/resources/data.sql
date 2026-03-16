-- Brands
INSERT INTO brands (brand_name) VALUES ('Nike');
INSERT INTO brands (brand_name) VALUES ('Octave');
INSERT INTO brands (brand_name) VALUES ('Forever21');
INSERT INTO brands (brand_name) VALUES ('Urban Planet');
INSERT INTO brands (brand_name) VALUES ('Bath and Body Works');
INSERT INTO brands (brand_name) VALUES ('Ubon');
INSERT INTO brands (brand_name) VALUES ('Adidas');
INSERT INTO brands (brand_name) VALUES ('Puma');
INSERT INTO brands (brand_name) VALUES ('ASICS');
INSERT INTO brands (brand_name) VALUES ('McDonalds');
INSERT INTO brands (brand_name) VALUES ('A&Ws');
INSERT INTO brands (brand_name) VALUES ('Dairy Queen');
INSERT INTO brands (brand_name) VALUES ('Subway');
INSERT INTO brands (brand_name) VALUES ('Jersey Mikes');

-- Products
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Air Max 270', 180, 'Nike running shoes', 1, 7);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Nike Sportswear Hoodie', 80, 'Comfortable hoodie', 1, 8);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Octave Wireless Earbuds', 120, 'Bluetooth earbuds', 2, 5);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Forever21 Summer Dress', 40, 'Casual summer dress', 3, 9);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Urban Planet Jeans', 60, 'Denim jeans', 4, 13);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Bath & Body Works Candle', 25, 'Scented candle', 5, 25);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Ubon Wireless Speaker', 70, 'Portable speaker', 6, 10);

-- Orders
INSERT INTO orders_table (order_date, total_amount, quantity) VALUES (CURRENT_TIMESTAMP(), 720, 4);
INSERT INTO orders_table (order_date, total_amount, quantity) VALUES (CURRENT_TIMESTAMP(), 240, 3);

-- Order Items
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 1, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 4, 2);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 7, 1);

INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 2, 1);
INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 5, 2);