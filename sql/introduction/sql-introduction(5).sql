USE my_shop;
SELECT * FROM customers ORDER BY join_date DESC;
SELECT * FROM products ORDER BY price;

SELECT * FROM products ORDER BY stock_quantity DESC, price DESC; #다중 정렬도 가능

SELECT * FROM products ORDER BY price DESC LIMIT 2;

SELECT * FROM products LIMIT 0,2;
SELECT * FROM products LIMIT 2,2;
SELECT * FROM products LIMIT 4,2;

SELECT DISTINCT customer_id FROM orders ORDER BY customer_id ;
SELECT DISTINCT customer_id, product_id FROM orders ORDER BY customer_id, product_id;

SELECT * FROM products;
SELECT * FROM products WHERE description IS NULL;
SELECT * FROM products ORDER BY description desc;

# description IS NULL 이라는 컬럼 생성 NULL 값은 1로 나옴
SELECT products_id, name, description, description IS NULL FROM products ORDER BY description IS NULL DESC , description DESC;