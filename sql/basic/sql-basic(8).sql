USE my_shop2;

select * from colors;
select * from sizes;

select 
CONCAT('기본티셔츠-', c.color, '-', s.size) as product_name,
s.size,
c.color
from sizes s
cross join colors c;

CREATE TABLE product_options (
	option_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    size VARCHAR(10) NOT NULL,
    color VARCHAR(20) NOT NULL
);

INSERT INTO product_options(product_name, size, color)
select 
CONCAT('기본티셔츠-', c.color, '-', s.size) as product_name,
s.size,
c.color
from sizes s
cross join colors c;

SELECT * FROM product_options;

SELECT * from orders;
select * from products;
select * from users;
#고객 이름, 이메일, order 의 주문날짜, 수량, product의 상품명, 상품가격
select 
	u.name,
    u.email,
    o.order_date,
    o.quantity,
    p.name,
    p.price
	from orders o 
    left join users u on o.user_id = u.user_id
    left join products p on o.product_id = p.product_id
    where o.order_date LIKE '2025-06%' AND u.address LIKE '서울%'
    order by order_date DESC;

