SELECT * FROM products WHERE products_id = 1;

UPDATE products
SET price = 9800, stock_quantity = 580
WHERE products_id = 1;

SELECT * FROM products WHERE products_id = 1;

DELETE FROM products WHERE products_id = 1;
SELECT * FROM products;

SET FOREIGN_KEY_CHECKS = 0;
truncate table products;
truncate table customers;
truncate table orders;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO customers (name, email, password, address)
VALUES ('강감찬', 'noName' , 'password123', '서울시 마포구'); 

INSERT INTO products (name, price, stock_quantity)
VALUES('베이직 반팔 티셔츠' , 19900, 220);

SELECT * FROM orders;
INSERT INTO orders (customer_id, product_id, quantity)
VALUES(1, 1, 1);
