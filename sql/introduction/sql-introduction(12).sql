USE my_shop;

SELECT category, COUNT(*) AS 상품개수 FROM order_stat GROUP BY category;

SELECT category , SUM(price *quantity) AS `카테고리별 금액` 
	FROM order_stat 
    GROUP BY category 
    HAVING `카테고리별 금액` >= 900000;
    
SELECT * FROM order_stat;

SELECT customer_name, COUNT(*) AS 주문횟수 FROM order_stat GROUP BY(customer_name) HAVING 주문횟수 >= 3;

SELECT category, COUNT(*) AS 주문횟수 FROM order_stat WHERE price >= 100000 GROUP BY category HAVING COUNT(*) >= 2;