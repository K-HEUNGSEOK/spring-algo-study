USE my_shop2;

select distinct o.product_id, p.name, p.price from orders o
	join products p on o.product_id = p.product_id;

#데이터가 많으면 성능이 좋지 않음
select product_id, name from products
	where product_id in (select distinct product_id from orders);
    
select 
	product_id, name, price
    from products p 
    where exists (select * from orders o where o.product_id = p.product_id);
    
select product_id, name, price
	from products p
    where NOT exists (select 1 from orders where product_id = p.product_id);
    
select name, price, (select avg(price) from products) as avg_price from products p;

select name, price, (select count(*) from orders o where o.product_id = p.product_id) as product_count from products p;

select name, price, count(o.product_id) from products p left join orders o on p.product_id = o.product_id group by p.product_id, p.name, p.price;

#이거를 가상 테이블이라고 생각해야함
select * from products;
select category, max(price) as max_price from products group by category;

select p.product_id, p.name, p.price
	from products p
	join(
		select category, max(price) as max_price 
        from products 
        group by category
    ) as cmp
    #카테고리와 max_price를 조인해서 같은 것만 남긴다.
on p.category = cmp.category and p.price = cmp.max_price; 
select * from users;
select * from orders o
	join users u on u.user_id = o.user_id
    where u.address Like '서울%';

select * from users u
	where u.user_id in (select user_id from users where address LIKE '서울%')