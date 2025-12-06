ALTER TABLE customers
CHANGE COLUMN costomer_id customer_id INT;
SET foreign_key_checks = 0;
ALTER TABLE customers
MODIFY customer_id INT AUTO_INCREMENT;
SET foreign_key_checks = 1;

CREATE TABLE orders(
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT '주문접수',
    
	CONSTRAINT fk_orders_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    CONSTRAINT fk_orders_products FOREIGN KEY(product_id) REFERENCES products(products_id)
);

INSERT INTO customers VALUES(NULL, '강감찬', 'test@naver.com', 'test_password', '서울시 관악구', '2025-06-11 10:30:00');
INSERT INTO customers VALUES(NULL, '이순신', 'test2@naver.com', 'test2_password', '서울시 관악구2', '2025-06-11 10:30:00');
SELECT * FROM customers;
INSERT INTO customers (name, email, password, address)
VALUE ('이완용', 'lee@naver.com', '나쁜놈123', '서울시 관악구');


INSERT INTO products (name, price, stock_quantity)
VALUES ('베이직 반팔 티셔츠', 19900, 200);
INSERT INTO products (name, price, stock_quantity)
VALUES ('초록색 반팔 티셔츠', 19900, 50);

INSERT INTO products (name,price,stock_quantity) VALUES
('검정양말', 1000, 1),
('초록양말', 1000, 1),
('노랑양말', 1000, 1);
SELECT * FROM products;