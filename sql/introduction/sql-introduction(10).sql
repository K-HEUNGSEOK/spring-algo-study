SELECT COUNT(*) FROM order_stat;
SELECT * FROM order_stat;
SELECT COUNT(category) FROM order_stat;

SELECT COUNT(*) AS 전체컬럼, COUNT(category) AS 일반컬럼 FROM order_stat;

SELECT SUM(price * quantity) AS `총 매출액`,
		AVG(price * quantity) AS `평균 주문 금액` FROM order_stat;
        
SELECT SUM(quantity) AS `총 판매수량`,
		AVG(quantity) AS `주문 당 평균 수량` FROM order_stat;

SELECT MAX(price) AS 최대주문금액, MIN(price) AS 최소주문금액 FROM order_stat;
SELECT MAX(order_date) AS '최근 주문일', MIN(order_date) AS '최초 주문일' FROM order_stat;

SELECT COUNT(DISTINCT customer_name) AS `고객 수` FROM order_stat; 