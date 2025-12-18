USE my_shop;

SELECT * FROM order_stat;

SELECT customer_name, COUNT(*) AS 주문횟수, 
					  SUM(price *quantity) AS 총구매금액 
                      FROM order_stat 
                      WHERE order_date < '2025-05-14' 
                      GROUP BY customer_name 
                      HAVING COUNT(*) >= 2 
                      ORDER BY 총구매금액 DESC
                      LIMIT 1;