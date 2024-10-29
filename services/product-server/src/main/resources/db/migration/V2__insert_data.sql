-- Insertion des catégories
SELECT '##################################################################################';

SELECT '# Insertion des catégories';

INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Electronics and gadgets', 'Electronics');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Home appliances and furniture', 'Home & Furniture');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Clothing and accessories', 'Fashion');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Sports and outdoor equipment', 'Sports');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Beauty and personal care', 'Beauty');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Books and media', 'Books & Media');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Toys and games', 'Toys');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Automotive and tools', 'Automotive');

-- Produits pour chaque catégorie
SELECT '# Produits pour chaque catégorie';

-- Produits pour Electronics
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Electronics';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Smartphone', 'Latest model smartphone', 100, 699.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Laptop', 'Lightweight and powerful laptop', 50, 1199.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Smartwatch', 'Waterproof smartwatch', 150, 199.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Headphones', 'Wireless noise-cancelling headphones', 200, 149.99, (SELECT id FROM category WHERE name = 'Electronics'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Tablet', '10-inch tablet with stylus', 120, 399.99, (SELECT id FROM category WHERE name = 'Electronics'));

-- Produits pour Home & Furniture
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Home & Furniture';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Sofa', 'Comfortable three-seater sofa', 20, 599.99, (SELECT id FROM category WHERE name = 'Home & Furniture'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Dining Table', '8-seater dining table', 30, 799.99, (SELECT id FROM category WHERE name = 'Home & Furniture'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Bookshelf', 'Wooden bookshelf with 5 shelves', 40, 199.99, (SELECT id FROM category WHERE name = 'Home & Furniture'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Bed', 'Queen size bed frame', 15, 499.99, (SELECT id FROM category WHERE name = 'Home & Furniture'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Wardrobe', 'Spacious wardrobe with sliding doors', 10, 699.99, (SELECT id FROM category WHERE name = 'Home & Furniture'));

-- Produits pour Fashion
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Fashion';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'T-shirt', 'Cotton T-shirt in various colors', 200, 19.99, (SELECT id FROM category WHERE name = 'Fashion'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Jeans', 'Blue denim jeans', 150, 49.99, (SELECT id FROM category WHERE name = 'Fashion'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Jacket', 'Leather jacket', 50, 149.99, (SELECT id FROM category WHERE name = 'Fashion'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Sneakers', 'Comfortable running sneakers', 100, 89.99, (SELECT id FROM category WHERE name = 'Fashion'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Dress', 'Elegant evening dress', 70, 99.99, (SELECT id FROM category WHERE name = 'Fashion'));

-- Produits pour Sports
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Sports';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Tennis Racket', 'Professional tennis racket', 60, 59.99, (SELECT id FROM category WHERE name = 'Sports'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Yoga Mat', 'Non-slip yoga mat', 120, 19.99, (SELECT id FROM category WHERE name = 'Sports'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Dumbbells', 'Set of dumbbells', 100, 39.99, (SELECT id FROM category WHERE name = 'Sports'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Running Shoes', 'Lightweight running shoes', 90, 79.99, (SELECT id FROM category WHERE name = 'Sports'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Bicycle Helmet', 'Safety helmet for biking', 50, 29.99, (SELECT id FROM category WHERE name = 'Sports'));

-- Produits pour Beauty
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Beauty';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Shampoo', 'Anti-dandruff shampoo', 200, 9.99, (SELECT id FROM category WHERE name = 'Beauty'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Face Cream', 'Hydrating face cream', 150, 29.99, (SELECT id FROM category WHERE name = 'Beauty'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Lipstick', 'Matte finish lipstick', 100, 14.99, (SELECT id FROM category WHERE name = 'Beauty'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Perfume', 'Long-lasting fragrance', 80, 49.99, (SELECT id FROM category WHERE name = 'Beauty'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Conditioner', 'Moisturizing hair conditioner', 180, 9.99, (SELECT id FROM category WHERE name = 'Beauty'));

-- Produits pour Books & Media
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Books & Media';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Novel', 'Best-selling novel', 300, 19.99, (SELECT id FROM category WHERE name = 'Books & Media'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Magazine', 'Monthly lifestyle magazine', 200, 5.99, (SELECT id FROM category WHERE name = 'Books & Media'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'E-book Reader', 'Portable e-book reader', 50, 89.99, (SELECT id FROM category WHERE name = 'Books & Media'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Comic Book', 'Popular comic book series', 120, 14.99, (SELECT id FROM category WHERE name = 'Books & Media'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Music Album', 'Top 10 music album', 100, 9.99, (SELECT id FROM category WHERE name = 'Books & Media'));

-- Produits pour Toys
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Toys';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Action Figure', 'Superhero action figure', 100, 24.99, (SELECT id FROM category WHERE name = 'Toys'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Board Game', 'Family board game', 70, 34.99, (SELECT id FROM category WHERE name = 'Toys'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Puzzle', '500-piece puzzle', 150, 12.99, (SELECT id FROM category WHERE name = 'Toys'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Doll', 'Doll with accessories', 90, 29.99, (SELECT id FROM category WHERE name = 'Toys'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Toy Car', 'Remote-controlled car', 80, 19.99, (SELECT id FROM category WHERE name = 'Toys'));

-- Produits pour Automotive
SELECT '--------------------------------------------------------------------------------';
SELECT '# Produits pour Automotive';
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Tire', 'All-season car tire', 60, 79.99, (SELECT id FROM category WHERE name = 'Automotive'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Car Battery', 'Long-lasting car battery', 30, 99.99, (SELECT id FROM category WHERE name = 'Automotive'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Engine Oil', 'Synthetic engine oil', 100, 29.99, (SELECT id FROM category WHERE name = 'Automotive'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Air Filter', 'High-performance air filter', 150, 14.99, (SELECT id FROM category WHERE name = 'Automotive'));
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Car Wax', 'Car wax for a glossy finish', 90, 12.99, (SELECT id FROM category WHERE name = 'Automotive'));

-- Confirmation
SELECT '# Data for 8 categories and 5 products per category has been inserted.';
