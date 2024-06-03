-- Insert entries into categories table
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (100, 'Mountain Bikes', 'BIKES', '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (101, 'Road Bikes', 'BIKES', '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (102, 'Brakes', 'PARTS', '2024-05-19 12:00:00 +02:00', '2024-05-19 12:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (103, 'Wheels', 'PARTS', '2024-05-19 13:00:00 +02:00', '2024-05-19 13:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (104, 'Hybrid Bikes', 'RENT_ITEMS', '2024-05-19 14:00:00 +02:00', '2024-05-19 14:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (105, 'Electric Bikes', 'RENT_ITEMS', '2024-05-19 15:00:00 +02:00', '2024-05-19 15:00:00 +02:00');

-- Insert entries into items table
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (100, 'Trek Mountain Bike', 'A high-quality mountain bike.', 10, 1200.00, 'https://rower-sport.pl/environment/cache/images/0_0_productGfx_35140/Marlin4_22_29759_A_Primary.webp', 100, '2024-05-19 10:30:00 +02:00', '2024-05-19 10:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (101, 'Giant Road Bike', 'A lightweight road bike.', 10, 1500.00, 'https://images2.giant-bicycles.com/b_white%2Cc_pad%2Ch_400%2Cq_80/fpskvr24m1nc01ybbfzh/MY24DefyAdvanced1_ColorACharcoal_MilkyWay.jpg', 101, '2024-05-19 11:30:00 +02:00', '2024-05-19 11:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (102, 'Shimano Brake Set', 'A reliable brake set.', 10, 200.00, 'https://images.bike24.com/i/mb/dc/c4/49/334315-00-d-704374.jpg', 102, '2024-05-19 12:30:00 +02:00', '2024-05-19 12:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (103, 'Bontrager Wheels', 'Durable and lightweight wheels.', 20, 500.00, 'https://granfondo-cycling.com/wp-content/uploads/sites/3/2021/04/Bontrager-Aeolus-2021-Wheels-News-0XX-003-810x540.jpg', 103, '2024-05-19 13:30:00 +02:00', '2024-05-19 13:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (104, 'Cannondale Hybrid Bike', 'A versatile hybrid bike.', 15, 800.00, 'https://i.ebayimg.com/images/g/jjAAAOSwfh9luMPh/s-l1200.webp', 104, '2024-05-19 14:30:00 +02:00', '2024-05-19 14:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (105, 'Specialized Electric Bike', 'An efficient electric bike.', 5, 2500.00, 'https://www.spectrumbike.pl/wp-content/uploads/2022/11/tero.png', 105, '2024-05-19 15:30:00 +02:00', '2024-05-19 15:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (106, 'Santa Cruz Mountain Bike', 'A high-performance mountain bike.', 8, 2200.00, 'https://a.allegroimg.com/s720/112d9f/aa1e8fe64fabb6ead37417fc7a05/Enduro-Santa-Cruz-Megatower-C-2-M-29-R-2024', 100, '2024-05-19 16:00:00 +02:00', '2024-05-19 16:00:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (107, 'Cervelo Road Bike', 'A top-of-the-line road bike.', 6, 3000.00, 'https://www.roadbike.pl/wp-content/uploads/2021/04/s-series-czarny.jpg', 101, '2024-05-19 16:30:00 +02:00', '2024-05-19 16:30:00 +02:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, created_at, modified_at) VALUES (108, 'SRAM Brake Set', 'High-quality brake set.', 12, 180.00, 'https://www.stifmtb.com/cdn/shop/products/level-brakes_1333x.jpg?v=1650965104', 102, '2024-05-19 17:00:00 +02:00', '2024-05-19 17:00:00 +02:00');

-- Insert entries into users table
INSERT INTO users (id, username, password, email, first_name, last_name, phone, created_at, modified_at) VALUES (100, 'johndoe', '$2a$10$KbQmX0trE/.xj8aJQxIl3uUh3dSO2Qnr6p/qz3lkUae.FUaf0W4ty', 'john.doe@example.com', 'John', 'Doe', 1234567890, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO users (id, username, password, email, first_name, last_name, phone, created_at, modified_at) VALUES (101, 'janedoe', '$2a$10$K6ShwqNlkl3sVz/LlkN8vea3hE/ZlXQ9e7orP78.B1A7kXzB7BF9a', 'jane.doe@example.com', 'Jane', 'Doe', 9876543210, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');

-- Insert entries into payments table
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (100, 1400.00, 'PayPal', 'COMPLETED', '2024-05-19 10:40:00 +02:00', '2024-05-19 10:40:00 +02:00');
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (101, 1700.00, 'Stripe', 'COMPLETED', '2024-05-19 11:40:00 +02:00', '2024-05-19 11:40:00 +02:00');

-- Insert entries into orders table
INSERT INTO orders (id, user_id, total, status, payment_id, created_at, modified_at) VALUES (100, 100, 1400.00, 'PENDING', 100, '2024-05-19 10:45:00 +02:00', '2024-05-19 10:45:00 +02:00');
INSERT INTO orders (id, user_id, total, status, payment_id, created_at, modified_at) VALUES (101, 101, 1700.00, 'DELIVERED', 101, '2024-05-19 11:45:00 +02:00', '2024-05-19 11:45:00 +02:00');

-- Insert entries into order_items table
INSERT INTO order_items (id, quantity, prize, order_id, item_id, created_at, modified_at) VALUES (100, 1, 1200.00, 100, 100, '2024-05-19 10:50:00 +02:00', '2024-05-19 10:50:00 +02:00');
INSERT INTO order_items (id, quantity, prize, order_id, item_id, created_at, modified_at) VALUES (101, 1, 1500.00, 101, 101, '2024-05-19 11:50:00 +02:00', '2024-05-19 11:50:00 +02:00');

-- Insert entries into rentals table
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (100, '2024-06-01 08:00:00 +02:00', '2024-06-07 20:00:00 +02:00', 300.00, 'IN_PROGRESS', 100, 100, 100, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (101, '2024-06-15 08:00:00 +02:00', '2024-06-20 20:00:00 +02:00', 250.00, 'REQUESTED', 101, 101, 101, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');
