USE my_shop2;
select * from products;
select category, avg(price) from products group by category ;

select * from products p1 
	where p1.price >= (
				select avg(p2.price) 
                from products p2 
                where p2.category = p1.category);