USE my_shop2;
select * from products;
select p.product_id, p.name, p.price, o.product_id, o.order_id 
	from products p 
    left join orders o on p.product_id = o.product_id
    where o.order_id is null
    order by p.price DESC;
    

select p.product_id, p.name, p.price, o.order_id, o.product_id 
	from orders o 
    right join products p on o.product_id = p.product_id
    where o.order_id is null;