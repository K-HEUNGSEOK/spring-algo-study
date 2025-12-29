use my_shop2;

select
	name,
    category,
    case category
		when '전자기기' THEN 'Elect'
		when '도서' THEN 'BOOKS'
        WHEN '패션' then 'fashion'
	END as category_english
    from products;
    
select
	order_id,
    quantity,
    CASE 
		when quantity >= 2 then '다량주문'
		when quantity = 1 then '단일주문'
	END as order_type
from orders
order by 
	CASE 
		when quantity >= 2 then 1
		when quantity = 1 then 2
	end asc;
    
select 
	case
		when stock_quantity >= 50 then '재고 충분'
		when stock_quantity >= 20 then '재고 보통'
		else '재고 부족'
	END as stock_level,
    count(*)
from products
group by stock_level;

select 
	u.name,
    count(o.order_id) as total_orders,
    count(case when p.category = '전자기기' then 1 end) as ele_orders,
    count(case when p.category = '도서' then 1 end) as book_orders,
    count(case when p.category = '패션' then 1 end) as fashion_orders
    from users u 
    left join orders o on o.user_id = u.user_id
    left join products p on o.product_id = p.product_id
    group by u.name;

