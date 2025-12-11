USE my_shop;

SELECT name, price, (price-(price * 0.15)) AS sale_price FROM products; 

SELECT CONCAT_WS('-',name,address) AS customer_info FROM customers;

SELECT name, COALESCE(description, name) AS product_info FROM products;

SELECT name, description, COALESCE(description, name, '정보없음') AS display_text FROM products;

SELECT * FROM customers;
SELECT email, SUBSTRING_INDEX(email, '@', 1) AS user_id , CHAR_LENGTH(SUBSTRING_INDEX(email, '@', 1)) AS id_length FROM customers;