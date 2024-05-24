-- Insert entries into categories table
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (100, 'Mountain Bikes', 'BIKES', '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (101, 'Road Bikes', 'BIKES', '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (102, 'Brakes', 'PARTS', '2024-05-19 12:00:00 +02:00', '2024-05-19 12:00:00 +02:00');

-- Insert entries into items table
INSERT INTO items (id, name, `desc`, price, category_id, created_at, modified_at) VALUES (100, 'Trek Mountain Bike', 'A high-quality mountain bike.', 1200.00, 100, '2024-05-19 10:30:00 +02:00', '2024-05-19 10:30:00 +02:00');
INSERT INTO items (id, name, `desc`, price, category_id, created_at, modified_at) VALUES (101, 'Giant Road Bike', 'A lightweight road bike.', 1500.00, 101, '2024-05-19 11:30:00 +02:00', '2024-05-19 11:30:00 +02:00');
INSERT INTO items (id, name, `desc`, price, category_id, created_at, modified_at) VALUES (102, 'Shimano Brake Set', 'A reliable brake set.', 200.00, 102, '2024-05-19 12:30:00 +02:00', '2024-05-19 12:30:00 +02:00');

-- Insert entries into users table
INSERT INTO users (id, username, password, email, first_name, last_name, phone, created_at, modified_at) VALUES (100, 'johndoe', '$2a$10$KbQmX0trE/.xj8aJQxIl3uUh3dSO2Qnr6p/qz3lkUae.FUaf0W4ty', 'john.doe@example.com', 'John', 'Doe', 1234567890, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO users (id, username, password, email, first_name, last_name, phone, created_at, modified_at) VALUES (101, 'janedoe', '$2a$10$K6ShwqNlkl3sVz/LlkN8vea3hE/ZlXQ9e7orP78.B1A7kXzB7BF9a', 'jane.doe@example.com', 'Jane', 'Doe', 9876543210, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');

-- Insert entries into payments table
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (100, 1400.00, 'PayPal', 'COMPLETED', '2024-05-19 10:40:00 +02:00', '2024-05-19 10:40:00 +02:00');
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (101, 1700.00, 'Stripe', 'COMPLETED', '2024-05-19 11:40:00 +02:00', '2024-05-19 11:40:00 +02:00');

-- Insert entries into orders table
INSERT INTO orders (id, user_id, total, payment_id, created_at, modified_at) VALUES (100, 100, 1400.00, 100, '2024-05-19 10:45:00 +02:00', '2024-05-19 10:45:00 +02:00');
INSERT INTO orders (id, user_id, total, payment_id, created_at, modified_at) VALUES (101, 101, 1700.00, 101, '2024-05-19 11:45:00 +02:00', '2024-05-19 11:45:00 +02:00');

-- Insert entries into order_items table
INSERT INTO order_items (id, quantity, order_id, item_id, created_at, modified_at) VALUES (100, 1, 100, 100, '2024-05-19 10:50:00 +02:00', '2024-05-19 10:50:00 +02:00');
INSERT INTO order_items (id, quantity, order_id, item_id, created_at, modified_at) VALUES (101, 1, 101, 101, '2024-05-19 11:50:00 +02:00', '2024-05-19 11:50:00 +02:00');

-- Insert entries into rentals table
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (100, '2024-06-01 08:00:00 +02:00', '2024-06-07 20:00:00 +02:00', 300.00, 'IN_PROGRESS', 100, 100, 100, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (101, '2024-06-15 08:00:00 +02:00', '2024-06-20 20:00:00 +02:00', 250.00, 'REQUESTED', 101, 101, 101, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');
