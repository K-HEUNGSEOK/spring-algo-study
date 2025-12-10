USE my_shop;

SELECT name AS 상품명, price AS 판매가 FROM products;

SELECT * FROM customers WHERE name = '장영실';

SELECT * FROM products WHERE price >= 10000 AND stock_quantity < 50;

SELECT name, price FROM products WHERE products_id IN (2,3,4);

SELECT name, address FROM customers WHERE address LIKE '서울특별시%';

SELECT * FROM products where description IS NULL;

SELECT * FROM products ORDER BY price DESC;

SELECT * FROM products ORDER BY price ASC, stock_quantity DESC;

SELECT * FROM customers ORDER BY join_date DESC LIMIT 2;

SELECT DISTINCT customer_id, product_id FROM orders;
SELECT * FROM products;
SELECT name AS `상품 이름`, stock_quantity AS `남은 수량` FROM products WHERE price >= 3000 AND stock_quantity <= 100 ORDER BY stock_quantity DESC LIMIT 3;