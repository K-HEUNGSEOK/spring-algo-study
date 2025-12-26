use my_shop2;
select product_id as 상품ID,
		name as 상품명,
        price as 가격
        from products p 
        where price = (select max(price) from products);
select * from products;


select o.order_id as 주문ID,
		o.user_id as 고객ID,
        o.order_date as 주문일시
		FROM orders o
        where o.product_id = (select product_id from orders where order_id = 1);

#고객별로 주문한 횟수를 봐야함 select 상관 서브쿼리
select name as 고객명,
		(select count(*) from orders o where o.user_id = u.user_id) as 총주문횟수
        from users u
        
