USE my_shop2;

select * from orders;

select orders.order_id,
	   orders.order_date, 
       orders.user_id as order_table_user_id, 
       users.user_id as user_table_user_id , 
       users.name 
from orders 
join users on orders.user_id = users.user_id;

select orders.order_id,
	   orders.order_date, 
       orders.user_id as order_table_user_id, 
       users.user_id as user_table_user_id , 
       users.name 
from users 
join orders on users.user_id = orders.user_id;


#user id , user name, order date
select u.user_id, 
	   u.name, 
       o.order_date 
       from orders AS o 
       join users as u 
       on o.user_id = u.user_id where status = 'COMPLETED';
