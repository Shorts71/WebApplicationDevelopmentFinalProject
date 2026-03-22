-- Brands
INSERT INTO brands (brand_name) VALUES ('Nike'); -- ID: 1
INSERT INTO brands (brand_name) VALUES ('Octave');  -- ID: 2
INSERT INTO brands (brand_name) VALUES ('Forever21'); -- ID: 3
INSERT INTO brands (brand_name) VALUES ('Urban Planet'); -- ID: 4
INSERT INTO brands (brand_name) VALUES ('Bath and Body Works'); -- ID: 5
INSERT INTO brands (brand_name) VALUES ('Ubon'); -- ID: 6
INSERT INTO brands (brand_name) VALUES ('Adidas'); -- ID: 7
INSERT INTO brands (brand_name) VALUES ('Puma'); -- ID: 8
INSERT INTO brands (brand_name) VALUES ('ASICS'); -- ID: 9
INSERT INTO brands (brand_name) VALUES ('McDonalds'); -- ID: 10
INSERT INTO brands (brand_name) VALUES ('A&Ws'); -- ID: 11
INSERT INTO brands (brand_name) VALUES ('Dairy Queen'); -- ID: 12
INSERT INTO brands (brand_name) VALUES ('Subway'); -- ID: 13
INSERT INTO brands (brand_name) VALUES ('Jersey Mikes'); -- ID: 14
INSERT INTO brands (brand_name) VALUES ('% Arabica'); -- ID: 15
INSERT INTO brands (brand_name) VALUES ('Abercrombie & Fitch'); -- ID: 16
INSERT INTO brands (brand_name) VALUES ('Aerie'); -- ID: 17
INSERT INTO brands (brand_name) VALUES ('Apple'); -- ID: 18
INSERT INTO brands (brand_name) VALUES ('Samsung'); -- ID: 19
INSERT INTO brands (brand_name) VALUES ('Best Buy'); -- ID: 20
INSERT INTO brands (brand_name) VALUES ('Bluenotes'); -- ID: 21
INSERT INTO brands (brand_name) VALUES ('Old Navy'); -- ID: 22
INSERT INTO brands (brand_name) VALUES ('Skechers'); -- ID: 23

-- Products
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Air Max 270', 180, 'Nike running shoes', 1, 7);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Nike Sportswear Hoodie', 80, 'Comfortable hoodie', 1, 8);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Octave Wireless Earbuds', 120, 'Bluetooth earbuds', 2, 5);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Forever21 Summer Dress', 40, 'Casual summer dress', 3, 9);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Urban Planet Jeans', 60, 'Denim jeans', 4, 13);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Bath & Body Works Candle', 25, 'Scented candle', 5, 25);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Ubon Wireless Speaker', 70, 'Portable speaker', 6, 10);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('UltraBoost', 250, 'Popular Adidas shoes', 7, 39);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Gel-Kayano 32', 220, 'Popular ASICS running shoes', 9, 16);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Big Mac Beef Patties', 5, 'Beef patties for the Big Mac', 10, 27);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('A&Ws Root Beer', 10, 'A&Ws famous root beer', 11, 99);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Waffle Cones', 3, 'Waffle Cones for Dairy Queen ice cream', 12, 78);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Flatbread', 7, 'Subways flatbread', 13, 49);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Deli Ham', 9, 'Deli ham for Jersey Mikes', 14, 77);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Espresso Beans', 15, 'Freshly grown espresso beans', 15, 71);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Straight Fit Jeans', 40, 'Size 32x34', 16, 31);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Swimwear', 20, 'Sizes S to XL', 17, 92);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Iphone 16 Pro Max', 1000, 'Screen Protectors included', 18, 70);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Galaxy Z Flip 6', 1200, 'Samsungs latest flip phone', 19, 15);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('65" Flatscreen TV', 500, 'Renders in 4k', 20, 61);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Graphic T-Shirt', 30, 'Tekken designs', 21, 58);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Blouse', 35, 'Blouses for the summer', 22, 66);
INSERT INTO products (name, price, description, brand_id, stock_count) VALUES ('Glide-Step Altus', 125, 'Skechers newest shoe', 23, 29);

-- Orders
--INSERT INTO orders_table (order_date, total_amount, quantity) VALUES (CURRENT_TIMESTAMP(), 720, 4);
--INSERT INTO orders_table (order_date, total_amount, quantity) VALUES (CURRENT_TIMESTAMP(), 240, 3);

INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 4, p.price * 4, CURRENT_TIMESTAMP from products p WHERE p.id = 12;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 5, p.price * 5, CURRENT_TIMESTAMP from products p WHERE p.id = 23;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 6, p.price * 6, CURRENT_TIMESTAMP from products p WHERE p.id = 2;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 9, p.price * 9, CURRENT_TIMESTAMP from products p WHERE p.id = 5;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 6, p.price * 6, CURRENT_TIMESTAMP from products p WHERE p.id = 13;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 20;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 10, p.price * 10, CURRENT_TIMESTAMP from products p WHERE p.id = 15;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 9;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 3, p.price * 3, CURRENT_TIMESTAMP from products p WHERE p.id = 17;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 7, p.price * 7, CURRENT_TIMESTAMP from products p WHERE p.id = 22;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 8;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 18;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 12, p.price * 12, CURRENT_TIMESTAMP from products p WHERE p.id = 12;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 5, p.price * 5, CURRENT_TIMESTAMP from products p WHERE p.id = 14;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 11;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 7, p.price * 7, CURRENT_TIMESTAMP from products p WHERE p.id = 3;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 5, p.price * 5, CURRENT_TIMESTAMP from products p WHERE p.id = 13;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 4, p.price * 4, CURRENT_TIMESTAMP from products p WHERE p.id = 7;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 14;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 23, p.price * 23, CURRENT_TIMESTAMP from products p WHERE p.id = 23;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 9, p.price * 9, CURRENT_TIMESTAMP from products p WHERE p.id = 9;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 6;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 20;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 12;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 4;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 10;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 5, p.price * 5, CURRENT_TIMESTAMP from products p WHERE p.id = 1;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 5, p.price * 5, CURRENT_TIMESTAMP from products p WHERE p.id = 23;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 9, p.price * 9, CURRENT_TIMESTAMP from products p WHERE p.id = 13;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 8, p.price * 8, CURRENT_TIMESTAMP from products p WHERE p.id = 21;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 10, p.price * 10, CURRENT_TIMESTAMP from products p WHERE p.id = 16;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 9, p.price * 9, CURRENT_TIMESTAMP from products p WHERE p.id = 2;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 4, p.price * 4, CURRENT_TIMESTAMP from products p WHERE p.id = 17;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 10, p.price * 10, CURRENT_TIMESTAMP from products p WHERE p.id = 19;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 10;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 6, p.price * 6, CURRENT_TIMESTAMP from products p WHERE p.id = 3;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 15;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 2, p.price * 2, CURRENT_TIMESTAMP from products p WHERE p.id = 22;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 6, p.price * 6, CURRENT_TIMESTAMP from products p WHERE p.id = 10;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 6, p.price * 6, CURRENT_TIMESTAMP from products p WHERE p.id = 15;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 19, p.price * 19, CURRENT_TIMESTAMP from products p WHERE p.id = 19;
INSERT INTO orders_table (product_id, quantity, total_amount, order_date) SELECT p.id, 3, p.price * 3, CURRENT_TIMESTAMP from products p WHERE p.id = 21;



-- Order Items
--INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 1, 1);
--INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 4, 2);
--INSERT INTO order_item (order_id, product_id, quantity) VALUES (1, 7, 1);
--
--INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 2, 1);
--INSERT INTO order_item (order_id, product_id, quantity) VALUES (2, 5, 2);