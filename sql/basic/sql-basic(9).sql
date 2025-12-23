USE my_shop2;

select * from products;
select * from orders;
select * from users;


select 
	p.name, 
    p.price 
    from products p 
    left join orders o 
    on p.product_id = o.product_id 
    where order_id is null and p.category = '전자기기';

select 
	u.name, 
    COUNT(o.order_id) 
    from users u 
    left join orders o 
    on u.user_id = o.user_id 
    group by u.name order by name;
    
select 
	u.name, 
    u.email 
    from orders o 
    right join users u 
    on o.user_id = u.user_id 
    where order_id is null;

select u.name, p.name
	from users u 
    left join orders o on u.user_id = o.user_id
    left join products p on p.product_id = o.product_id
    order by u.name, p.name;

select * from employees;

select 
	m.employee_id, 
    m.name, 
    m.manager_id, 
    e.name
    from employees e 
    join employees m on e.employee_id = m.manager_id 
    where e.name = '최과장';
    
CREATE TABLE materials(
	material VARCHAR(20) PRIMARY KEY
);
select * from sizes;
select * from colors;
INSERT INTO materials(material) VALUES('Cotton'), ('Silk');
select
	count(*) over(),
	concat('기본티셔츠','-', c.color,'-', s.size,'-', m.material),
    s.size,
    c.color,
    m.material
    from sizes s
    cross join colors c
    cross join materials m;
    
select 
	u.name,
    p.name,
    o.order_date,
    o.quantity
	from orders o
    left join users u on o.user_id = u.user_id
    left join products p on o.product_id = p.product_id
    where u.name = '네이트'
    order by order_date DESC;

select * from users;

select 
	u.name,
    sum(p.price * o.quantity)
    from orders o
    left join users u on o.user_id = u.user_id
    left join products p on o.product_id = p.product_id
    where u.address Like '서울%'
    group by u.name
    order by sum(p.price * o.quantity) DESC;