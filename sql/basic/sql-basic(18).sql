USE my_shop2;
select * from users;

select 
    COUNT(*),
	CASE
		WHEN birth_date >= '1990-01-01' AND birth_date < '2000-01-01' THEN '1990년대생'
		WHEN birth_date >= '1980-01-01' AND birth_date < '1990-01-01' THEN '1980년대생'
		ELSE '그 이전 출생'
        END AS 태어난날짜
	FROM users
    GROUP BY 태어난날짜;

SELECT
COUNT(*),
    CASE
		when year(birth_date) >= 1990 then '1990년대생'
		when year(birth_date) >= 1980 then '1980년대생'
		else '그 외 출생'
	END as birth_decade
from users
GROUP BY birth_decade; #원래 순서상 안되는데 mySQL 에서 허락해준 것

select status, count(*) from orders
group by status;

select 
	distinct (select count(*) from orders) as total,
    (select count(*) from orders where status = 'COMPLETED') as COMPLETED_count,
    (select count(*) from orders where status = 'SHIPPED') as SHIPPED_count,
    (select count(*) from orders where status = 'PENDING') as PENDING_count
    from orders;

#count 는 null이 아닌 값을 다 센다
select count(case when status = 'COMPLETED' THEN 1 END) FROM orders;
select sum(case when status = 'COMPLETED' THEN 1 ELSE 0 END) FROM orders;

select
	count(*) as total_count,
    sum(case when status = 'COMPLETED' then 1 else 0 end) as COMPLETED_count,
    sum(case when status = 'SHIPPED' then 1 else 0 end) as SHIPPED_count,
    sum(case when status = 'PENDING' then 1 else 0 end) as PENDING_count
from orders;

#삼품 카테고리별로, 상태별 주문 건수를 집계하라 
select
	p.category,
	count(*) as total_count,
	count(case when status = 'COMPLETED' then 1 end) as COMPLETED_count,
    count(case when status = 'SHIPPED' then 1 end)as SHIPPED_count,   
    count(case when status = 'PENDING' then 1 end)as PENDING_count
from orders o
join products p on o.product_id = p.product_id
group by p.category;