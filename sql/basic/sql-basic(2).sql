USE my_shop2;

select * from orders;
select * from users;
SELECT * FROM orders JOIN users ON orders.user_id = users.user_id;

select users.user_id, name, order_date 
	from orders 
    join users on orders.user_id = users.user_id 
    where orders.status = 'COMPLETED';
    
