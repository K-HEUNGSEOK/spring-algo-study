USE my_shop2;

select user_id, name, email from users where user_id = 1;

select order_id, product_id, user_id from orders where user_id = 1;


select o.order_id, o.product_id, o.user_id as orders_user_id , u.user_id as users_user_id, u.name, u.email
from orders o
join users u on o.user_id = u.user_id
where o.user_id = 1;

select 
	u.user_id as users_user_id,
    u.name,
    u.email,
    o.order_id,
    o.product_id,
    o.user_id as orders_user_id
    from users u
    join orders o
    on u.user_id = o.user_id
    where u.user_id = 1;

select user_id, name, email from users;
select order_id, product_id, user_id from orders;

select 
	o.order_id, 
    o.user_id as order_user_id,
    u.user_id as users_user_id, 
    u.name ,
    u.email
    from orders o 
    join users u 
    on o.user_id = u.user_id
    order by u.user_id asc;

select 
	o.order_id, 
    o.user_id as order_user_id,
    u.user_id as users_user_id, 
    u.name ,
    u.email
    from users u 
    join orders o
    on u.user_id = o.user_id
    order by u.user_id asc;
    
select * from employees;

select 
	e.name as 직원이름,
    m.name as 상사이름
	from employees e 
    left join employees m on e.manager_id = m.employee_id;