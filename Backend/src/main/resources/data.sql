-- CATEGORIES
-- BIKES
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (1, 'Mountain Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (2, 'Road Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (3, 'Hybrid Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (4, 'Electric Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (5, 'Folding Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (6, 'Cruiser Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (7, 'Kids Bikes', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (8, 'Other', 'BIKES', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
-- PARTS
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (21, 'Brakes', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (22, 'Drivetrain', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (23, 'Wheels', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (24, 'Steering', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (25, 'Seating', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (26, 'Pedals', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (27, 'Suspension', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (28, 'Other', 'PARTS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
-- RENT_ITEMS
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (41, 'Mountain Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (42, 'Road Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (43, 'Hybrid Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (44, 'Electric Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (45, 'Folding Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (46, 'Cruiser Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (47, 'Kids Bikes', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO categories (id, name, super_category, created_at, modified_at) VALUES (48, 'Other', 'RENT_ITEMS', '2024-06-04 00:00:00', '2024-06-04 00:00:00');

-- BIKE_DETAILS
-- BIKES
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (101, 'Trek', 'Marlin 4', 14.5, '27.5', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (102, 'Giant', 'Defy Advanced 1', 8.9, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (103, 'Cannondale', 'Hybrid', 13.2, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (104, 'Specialized', 'Turbo Levo', 20.5, '29', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (105, 'Dahon', 'Folding Bike', 12.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (106, 'Electra', 'Cruiser', 16.5, '26', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (107, 'Huffy', 'Kids Bike', 9.5, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (108, 'Tracer', 'BMX', 11.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (109, 'Trek', 'Marlin 4 Pro', 14.5, '27.5', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (110, 'Giant', 'Defy Advanced 1 Pro', 8.9, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (111, 'Cannondale', 'Hybrid Pro', 13.2, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (112, 'Specialized', 'Turbo Levo Pro', 20.5, '29', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (113, 'Dahon', 'Folding Bike Pro', 12.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (114, 'Electra', 'Cruiser Pro', 16.5, '26', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (115, 'Huffy', 'Kids Bike Pro', 9.5, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (116, 'Tracer', 'BMX Pro', 11.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (117, 'Trek', 'Marlin 4 Pro+', 14.5, '27.5', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (118, 'Giant', 'Defy Advanced 1 Pro+', 8.9, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (119, 'Cannondale', 'Hybrid Pro+', 13.2, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (120, 'Specialized', 'Turbo Levo Pro+', 20.5, '29', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
-- RENT_ITEMS
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (141, 'Trek', 'Marlin 4', 14.5, '27.5', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (142, 'Giant', 'Defy Advanced 1', 8.9, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (143, 'Cannondale', 'Hybrid', 13.2, '28', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (144, 'Specialized', 'Turbo Levo', 20.5, '29', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (145, 'Dahon', 'Folding Bike', 12.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (146, 'Electra', 'Cruiser', 16.5, '26', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (147, 'Huffy', 'Kids Bike', 9.5, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO bike_details (id, brand, model, weight, wheel_size, created_at, modified_at) VALUES (148, 'Tracer', 'BMX', 11.0, '20', '2024-06-04 00:00:00', '2024-06-04 00:00:00');

-- PART_DETAILS
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (121, 'Aluminum', 'Brake Set', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (122, 'Steel', 'Drivetrain', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (123, 'Carbon', 'Wheel', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (124, 'Carbon', 'Handlebar', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (125, 'Synthetic', 'Saddle', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (126, 'Aluminum', 'Pedal', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (127, 'Aluminum', 'Fork', '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO part_details (id, material, part_type, created_at, modified_at) VALUES (128, 'Steel', 'Pump', '2024-06-04 00:00:00', '2024-06-04 00:00:00');

-- ITEMS
-- BIKES
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (101, 'Trek Mountain Bike', 'A high-quality mountain bike.', 10, 1200.00, 'https://rower-sport.pl/environment/cache/images/0_0_productGfx_35140/Marlin4_22_29759_A_Primary.webp', 1, 101, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (102, 'Giant Road Bike', 'A fast and lightweight road bike.', 8, 1500.00, 'https://images2.giant-bicycles.com/b_white%2Cc_pad%2Ch_400%2Cq_80/fpskvr24m1nc01ybbfzh/MY24DefyAdvanced1_ColorACharcoal_MilkyWay.jpg', 2, 102, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (103, 'Cannondale Hybrid Bike', 'A versatile hybrid bike for city and trail.', 12, 800.00, 'https://i.ebayimg.com/images/g/jjAAAOSwfh9luMPh/s-l1200.webp', 3, 103, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (104, 'Specialized Electric Bike', 'An electric bike with powerful motor.', 5, 2500.00, 'https://immotion.pl/9516-large_default/rower-elektryczny-specialized-turbo-levo-comp-alloy-2024.jpg', 4, 104, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (105, 'Dahon Folding Bike', 'A compact and portable folding bike.', 15, 600.00, 'https://eu.dahon.com/wp-content/uploads/2023/03/Mini-349-Tidal-Obsidian-min.jpg', 5, 105, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (106, 'Electra Cruiser Bike', 'A stylish and comfortable cruiser bike.', 7, 700.00, 'https://fabrykarowerow.com/wp-content/uploads/2022/03/CruiserGoStepOver_22_35208_B_Primary.jpg', 6, 106, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (107, 'Huffy Kids Bike', 'A safe and fun bike for kids.', 20, 200.00, 'https://i5.walmartimages.com/seo/Huffy-20-in-Sea-Star-Kids-Bike-for-Girls-Ages-5-and-up-Child-Blue-and-Pink_8f0a7c3f-245f-43ab-baf8-18c85904abe1_1.8222568f9c6768ee6ba8c39ee21e553d.jpeg', 7, 107, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (108, 'Tracer BMX Bike', 'A freestyle BMX for beginners and advanced riders.', 10, 400.00, 'https://tracerbikes.com/cdn/shop/products/shinningblack1.jpg?v=1640307102&width=1600', 8, 108, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (109, 'Trek Mountain Bike Pro', 'A high-quality mountain bike.', 10, 1200.00, 'https://rower-sport.pl/environment/cache/images/0_0_productGfx_35140/Marlin4_22_29759_A_Primary.webp', 1, 109, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (110, 'Giant Road Bike Pro', 'A fast and lightweight road bike.', 8, 1500.00, 'https://images2.giant-bicycles.com/b_white%2Cc_pad%2Ch_400%2Cq_80/fpskvr24m1nc01ybbfzh/MY24DefyAdvanced1_ColorACharcoal_MilkyWay.jpg', 2, 110, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (111, 'Cannondale Hybrid Bike Pro', 'A versatile hybrid bike for city and trail.', 12, 800.00, 'https://i.ebayimg.com/images/g/jjAAAOSwfh9luMPh/s-l1200.webp', 3, 111, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (112, 'Specialized Electric Bike Pro', 'An electric bike with powerful motor.', 5, 2500.00, 'https://immotion.pl/9516-large_default/rower-elektryczny-specialized-turbo-levo-comp-alloy-2024.jpg', 4, 112, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (113, 'Dahon Folding Bike Pro', 'A compact and portable folding bike.', 15, 600.00, 'https://eu.dahon.com/wp-content/uploads/2023/03/Mini-349-Tidal-Obsidian-min.jpg', 5, 113, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (114, 'Electra Cruiser Bike Pro', 'A stylish and comfortable cruiser bike.', 7, 700.00, 'https://fabrykarowerow.com/wp-content/uploads/2022/03/CruiserGoStepOver_22_35208_B_Primary.jpg', 6, 114, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (115, 'Huffy Kids Bike Pro', 'A safe and fun bike for kids.', 20, 200.00, 'https://i5.walmartimages.com/seo/Huffy-20-in-Sea-Star-Kids-Bike-for-Girls-Ages-5-and-up-Child-Blue-and-Pink_8f0a7c3f-245f-43ab-baf8-18c85904abe1_1.8222568f9c6768ee6ba8c39ee21e553d.jpeg', 7, 115, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (116, 'Tracer BMX Bike Pro', 'A freestyle BMX for beginners and advanced riders.', 10, 400.00, 'https://tracerbikes.com/cdn/shop/products/shinningblack1.jpg?v=1640307102&width=1600', 8, 116, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (117, 'Trek Mountain Bike Pro+', 'A high-quality mountain bike.', 10, 1200.00, 'https://rower-sport.pl/environment/cache/images/0_0_productGfx_35140/Marlin4_22_29759_A_Primary.webp', 1, 117, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (118, 'Giant Road Bike Pro+', 'A fast and lightweight road bike.', 8, 1500.00, 'https://images2.giant-bicycles.com/b_white%2Cc_pad%2Ch_400%2Cq_80/fpskvr24m1nc01ybbfzh/MY24DefyAdvanced1_ColorACharcoal_MilkyWay.jpg', 2, 118, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (119, 'Cannondale Hybrid Bike Pro+', 'A versatile hybrid bike for city and trail.', 12, 800.00, 'https://i.ebayimg.com/images/g/jjAAAOSwfh9luMPh/s-l1200.webp', 3, 119, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (120, 'Specialized Electric Bike Pro+', 'An electric bike with powerful motor.', 5, 2500.00, 'https://immotion.pl/9516-large_default/rower-elektryczny-specialized-turbo-levo-comp-alloy-2024.jpg', 4, 120, '2024-06-04 00:00:00', '2024-06-04 00:00:00');

-- PARTS
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (121, 'Shimano Brake Set', 'High-performance bicycle brakes.', 50, 100.00, 'https://images.bike24.com/i/mb/dc/c4/49/334315-00-d-704374.jpg', 21, 121, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (122, 'SRAM Drivetrain', 'Efficient drivetrain components.', 30, 300.00, 'https://www.sram.com/globalassets/image-hierarchy/sram-product-root-images/groupset/groupset/gs-nx-1-a1/steelchainringblacksidel.jpg?w=1000', 22, 122, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (123, 'Bontrager Wheels', 'Durable and lightweight wheels.', 40, 250.00, 'https://cdn.mantel.com/images/product.php?image_id=156083&w=760&h=570', 23, 123, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (124, 'Carbon Handlebars', 'Lightweight and strong handlebars.', 35, 150.00, 'https://dqh479dn9vg99.cloudfront.net/wp-content/uploads/sites/9/2019/01/02180238/zipp_sl-70_bars-970x587.jpg', 24, 124, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (125, 'Comfort Saddles', 'Comfortable bike saddles.', 45, 50.00, 'https://www.sefiles.net/images/library/zoom/specialized-bg-comfort-gel-saddle-367377-1.jpg', 25, 125, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (126, 'Clipless Pedals', 'High-efficiency bike pedals.', 25, 80.00, 'https://m.media-amazon.com/images/I/711klFQM9GS._AC_UF1000,1000_QL80_.jpg', 26, 126, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (127, 'RockShox Forks', 'Top-quality suspension forks.', 20, 400.00, 'https://www.sram.com/globalassets/image-hierarchy/sram-product-root-images/suspension---forks/suspension---forks/fs-sid-ultimate-2-position-d1/productassets_fs-sid-ult2-d1_fg/fs-sid-ult2-crn-29-sb-120-blu-44-d1-c-3q-v-v2.png?w=856&quality=80&format=jpg', 27, 127, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, part_details_id, created_at, modified_at) VALUES (128, 'Bike Pump Set', 'Bike pump set with sealing patches and different needles.', 70, 20.00, 'https://m.media-amazon.com/images/I/61ltFbgVqmL._AC_SL1500_.jpg', 28, 128, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
-- RENT_ITEMS
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (141, 'Trek Mountain Bike', 'A high-quality mountain bike.', 1, 30.00, 'https://rower-sport.pl/environment/cache/images/0_0_productGfx_35140/Marlin4_22_29759_A_Primary.webp', 41, 141, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (142, 'Giant Road Bike', 'A fast and lightweight road bike.', 1, 40.00, 'https://images2.giant-bicycles.com/b_white%2Cc_pad%2Ch_400%2Cq_80/fpskvr24m1nc01ybbfzh/MY24DefyAdvanced1_ColorACharcoal_MilkyWay.jpg', 42, 142, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (143, 'Cannondale Hybrid Bike', 'A versatile hybrid bike for city and trail.', 1, 25.00, 'https://i.ebayimg.com/images/g/jjAAAOSwfh9luMPh/s-l1200.webp', 43, 143, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (144, 'Specialized Electric Bike', 'An electric bike with powerful motor.', 1, 50.00, 'https://immotion.pl/9516-large_default/rower-elektryczny-specialized-turbo-levo-comp-alloy-2024.jpg', 44, 144, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (145, 'Dahon Folding Bike', 'A compact and portable folding bike.', 1, 20.00, 'https://eu.dahon.com/wp-content/uploads/2023/03/Mini-349-Tidal-Obsidian-min.jpg', 45, 145, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (146, 'Electra Cruiser Bike', 'A stylish and comfortable cruiser bike.', 1, 35.00, 'https://fabrykarowerow.com/wp-content/uploads/2022/03/CruiserGoStepOver_22_35208_B_Primary.jpg', 46, 146, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (147, 'Huffy Kids Bike', 'A safe and fun bike for kids.', 1, 15.00, 'https://i5.walmartimages.com/seo/Huffy-20-in-Sea-Star-Kids-Bike-for-Girls-Ages-5-and-up-Child-Blue-and-Pink_8f0a7c3f-245f-43ab-baf8-18c85904abe1_1.8222568f9c6768ee6ba8c39ee21e553d.jpeg', 47, 147, '2024-06-04 00:00:00', '2024-06-04 00:00:00');
INSERT INTO items (id, name, `desc`, quantity, price, image_url, category_id, bike_details_id, created_at, modified_at) VALUES (148, 'Tracer BMX Bike', 'A freestyle BMX for beginners and advanced riders.', 1, 25.00, 'https://tracerbikes.com/cdn/shop/products/shinningblack1.jpg?v=1640307102&width=1600', 48, 148, '2024-06-04 00:00:00', '2024-06-04 00:00:00');

-- USERS
-- Password: password123
INSERT INTO users (id, username, password, email, first_name, last_name, phone, role, active, created_at, modified_at) VALUES (100, 'johndoe', '$2a$10$yIrxbAfqvQAK4xiqhxI4XeFzAvpHqN83Rw2GZTU5MAbWWg7RnKJ/G', 'john.doe@example.com', 'John', 'Doe', 1234567890, 'ROLE_ADMIN', true, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
-- Password: password456
INSERT INTO users (id, username, password, email, first_name, last_name, phone, role, active, created_at, modified_at) VALUES (101, 'janedoe', '$2a$10$g0OtfOU0hxJAHrxeoVQ0c.6SURuLJfFjebgkqDbNN33Kp/3oe.eIa', 'jane.doe@example.com', 'Jane', 'Doe', 9876543210, 'ROLE_USER', true, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');

-- PAYMENTS
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (100, 1400.00, 'PayPal', 'COMPLETED', '2024-05-19 10:40:00 +02:00', '2024-05-19 10:40:00 +02:00');
INSERT INTO payments (id, amount, provider, status, created_at, modified_at) VALUES (101, 1700.00, 'Stripe', 'COMPLETED', '2024-05-19 11:40:00 +02:00', '2024-05-19 11:40:00 +02:00');

-- ORDERS
INSERT INTO orders (id, user_id, total, status, payment_id, created_at, modified_at) VALUES (100, 100, 1400.00, 'PENDING', 100, '2024-05-19 10:45:00 +02:00', '2024-05-19 10:45:00 +02:00');
INSERT INTO orders (id, user_id, total, status, payment_id, created_at, modified_at) VALUES (101, 101, 1700.00, 'DELIVERED', 101, '2024-05-19 11:45:00 +02:00', '2024-05-19 11:45:00 +02:00');

-- ORDER_ITEMS
INSERT INTO order_items (id, quantity, prize, order_id, item_id, created_at, modified_at) VALUES (100, 1, 1200.00, 100, 101, '2024-05-19 10:50:00 +02:00', '2024-05-19 10:50:00 +02:00');
INSERT INTO order_items (id, quantity, prize, order_id, item_id, created_at, modified_at) VALUES (101, 1, 1500.00, 101, 102, '2024-05-19 11:50:00 +02:00', '2024-05-19 11:50:00 +02:00');

-- RENTALS
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (100, '2024-06-01', '2024-06-07', 300.00, 'IN_PROGRESS', 141, 100, 100, '2024-05-19 10:00:00 +02:00', '2024-05-19 10:00:00 +02:00');
INSERT INTO rentals (id, rental_start, rental_end, total, status, item_id, user_id, payment_id, created_at, modified_at) VALUES (101, '2024-06-15', '2024-06-20', 250.00, 'REQUESTED', 142, 101, 101, '2024-05-19 11:00:00 +02:00', '2024-05-19 11:00:00 +02:00');
