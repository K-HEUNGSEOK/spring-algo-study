USE my_shop;
SELECT * FROM order_stat;

SELECT category, COUNT(*) AS 주문건수 FROM order_stat GROUP BY category;

SELECT customer_name, COUNT(*) AS '주문건수' FROM order_stat GROUP BY customer_name;

SELECT customer_name, COUNT(*) AS `총 주문 횟수`, SUM(quantity) AS `총 구매 수량`, SUM(price * quantity) AS '합계금액'
FROM order_stat GROUP BY customer_name ORDER BY `합계금액` DESC;

SELECT customer_name, category, SUM(price * quantity) AS `카테고리별 구매 금액`
	FROM order_stat GROUP BY customer_name, category ORDER BY customer_name , `카테고리별 구매 금액` DESC;
