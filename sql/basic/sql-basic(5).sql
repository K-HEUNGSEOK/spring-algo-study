USE my_shop2;

select  o.user_id, u.name from orders o join users u on o.user_id = u.user_id;

select u.user_id, u.name, o.user_id, o.order_id from users u LEFT JOIN orders o on u.user_id = o.user_id where o.user_id is null;