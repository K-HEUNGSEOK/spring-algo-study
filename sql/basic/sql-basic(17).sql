USE my_shop2;

select * from orders;

select
	order_id,
    user_id,
    product_id,
    quantity,
    status,
    CASE status
		WHEN 'PENDING' THEN '주문 대기'
		WHEN 'COMPLETED' THEN '결제 완료'
		WHEN 'SHIPPED' THEN '배송'
		WHEN 'CANCELED' THEN '취소'
        ELSE '알 수 없음'
	END AS status_korean
    from orders;
    
    #10만원 고가 3만안원 중가 그외에는 저가
    select
		product_id,
        name,
        category,
        price,
		CASE
			WHEN price >= 100000 THEN '고가'
            WHEN price >= 30000 THEN '중가'
            ELSE '저가'
		END as price_korea
        from products
		order by
        CASE
			WHEN price >= 100000 THEN 1
            WHEN price >= 30000 THEN 2
            ELSE 3
		END ASC;