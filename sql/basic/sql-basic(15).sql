USE my_shop2;

CREATE TABLE retired_users(
	id BIGINT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    retired_date DATE NOT NULL
);

INSERT INTO retired_users (id, name, email, retired_date) VALUES
(1, '션', 'sean@example.com', '2024-12-31'),
(7, '아이작 뉴턴', 'newton@example.com', '2025-01-10');

select * from retired_users;
select * from users;

select name, email from users
union
select name, email from retired_users;

select u.name, u.email
	from users u
    join orders o on u.user_id = o.user_id
    left join products p on p.product_id = o.product_id
    where p.category = '전자기기'
union
select u.name, u.email
	from users u
    where address Like '서울%';

select name, email from users
union
select name, email from retired_users
order by name;