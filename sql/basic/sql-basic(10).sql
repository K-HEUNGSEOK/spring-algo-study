use my_shop2;

select * from products;
select avg(price) from products;

select name,price from products where price > (select avg(price) from products);

select address from users where user_id = 1;
select name , address from users where address = '서울시 강남구';

select name, address
	from users
    where address = (select address from users where user_id = 1);

select product_id, name from products where category = '전자기기';
select * from orders where product_id in (1,2,3,6) order by quantity;

select * from orders where product_id IN (select product_id from products where category = '전자기기');

#전자기기 상품의 최소값 보다 비싼 상품
select * from products;
SELECT name, price from products 
where price > ANY (select price from products where category = '전자기기');

select * from products;
SELECT name, price from products 
where price > (select min(price) from products where category = '전자기기');
