USE my_shop2;

select u.name, u.email
	from users u
union
select name, email
	from retired_users;
    
select u.name as 고객명,
		u.email as 이메일
        from users u
        join orders o on u.user_id = o.user_id
        join products p on p.product_id = o.product_id
        where p.category = '전자기기'	
union all
select distinct u.name, u.email from users u
	join orders o on u.user_id = o.user_id
    where o.quantity > 1;

select * from employees;
select u.created_at as 이벤트_날짜,
		'고객 가입' as 이벤트_종류,
        name as 상세_내용
	from users u
union all
select order_date, '상품 주문' as 이벤트_종류, p.name as 상세_내용
	from orders o
    join products p on o.product_id = p.product_id;

select u.name as 이름, '고객' as 역할, u.email as 이메일
	from users u
union
select e.name, '직원', concat(e.name, '@my_shop.com')
	from employees e
order by 이름;