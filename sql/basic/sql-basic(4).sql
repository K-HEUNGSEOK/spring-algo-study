USE my_shop2;


select * from orders;
select * from products;

select o.order_id, 
		p.name, 
        o.quantity  
        from orders o 
        join products p 
        on o.product_id = p.product_id 
        order by order_id ASC;


select o.order_id, u.name, p.name, o.order_date 
from orders o 
join users u on o.user_id = u.user_id 
join products p on o.product_id = p.product_id  
where o.status = 'SHIPPED';

#order 랑 user 같은 애들만 추출하고, 그 뒤에 가격을 붙여서 하면된다
select u.name, SUM(p.price * o.quantity) AS total_price
from orders o
join users u on o.user_id = u.user_id
join products p on o.product_id = p.product_id
group by u.name
order by total_price DESC;