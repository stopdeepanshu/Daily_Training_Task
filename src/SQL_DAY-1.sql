-- creating a product table
CREATE TABLE product (
    prod_id SERIAL PRIMARY KEY,
    prod_name VARCHAR(100) NOT NULL,
    prod_desc TEXT,
    price NUMERIC(10,2) NOT NULL,
    prod_category VARCHAR(50) NOT NULL
);

-- Display all products
SELECT * FROM product;

-- Count products per category
SELECT prod_category, COUNT(*) AS countProd
FROM product
GROUP BY prod_category;


-- Count products per category and sort ascending
SELECT prod_category, COUNT(*) AS countProd
FROM product
GROUP BY prod_category
ORDER BY countProd ASC;

-- Get product with highest price
SELECT *
FROM product
WHERE price = (SELECT MAX(price) FROM product);


--find the second highest price
select * from product where price=(select max(price) from product where price<(
										select max(price) from product
									    ));

-- update the price of all electronic device so that new price is 10% lesser than the original price.
update product 
set price=price-(price* 0.1)
where prod_category='Electronics';

-- delete the product having prices less than average price.
delete from product
where price<(select avg(price) from product);

-- insert data in the table
INSERT INTO product (prod_id, prod_name, prod_desc, price, prod_category) VALUES
(701, 'Laptop Pro', '16GB RAM i7 Laptop', 75000, 'Electronics'),
(702, 'Smart TV', '55 inch 4K UHD TV', 52000, 'Electronics'),
(703, 'Headphones', 'Noise cancelling headset', 8500, 'Accessories'),
(704, 'Office Chair', 'Ergonomic office chair', 12000, 'Furniture'),
(705, 'Dining Table', 'Wooden 6 seater table', 30000, 'Furniture'),
(706, 'Refrigerator', 'Double door fridge', 45000, 'Appliances'),
(707, 'Microwave', 'Convection microwave oven', 15000, 'Appliances'),
(708, 'T-Shirt', 'Cotton round neck t-shirt', 799, 'Clothing'),
(709, 'Jeans', 'Slim fit denim jeans', 1999, 'Clothing'),
(710, 'Sneakers', 'Running sports shoes', 3499, 'Footwear'),
(711, 'Washing Machine', 'Fully automatic washer', 38000, 'Appliances'),
(712, 'Tablet', '10 inch Android tablet', 18000, 'Electronics'),
(713, 'Backpack', 'Waterproof travel bag', 2499, 'Accessories'),
(714, 'Watch', 'Analog wrist watch', 4999, 'Accessories'),
(715, 'Sofa', '3 seater leather sofa', 55000, 'Furniture'),
(716, 'Mixer Grinder', '750W kitchen mixer', 3999, 'Appliances'),
(717, 'Novel Book', 'Fiction bestseller novel', 599, 'Books'),
(718, 'Notebook', 'Hardcover ruled notebook', 299, 'Stationery'),
(719, 'Gaming Mouse', 'RGB wired gaming mouse', 1499, 'Electronics'),
(720, 'Water Bottle', 'Steel insulated bottle', 899, 'Home');


-- delete the product category wise whose price is less than average price in that specififc category.
SELECT * FROM product;


delete from product p
where price < (select avg(price) from product p1 where p1.prod_category=p.prod_category);

-- create a table fo order having  feilds like ord_id, ord_date,ord_type and propd_id as foreign key
-- also ensure that whenever a data changes in the parent table, it should get reflected in the child table.


create table orders(order_id integer primary key,
			order_date date,
			order_type varchar(20) not null,
			product_id integer,

		constraint fk_product
		foreign key (product_id)
		references product(prod_id)
)

select * from product;
select * from orders;

alter table  prders RENAME TO orders;

drop table orders;

TRUNCATE product CASCADE;

-- insert data in order table
INSERT INTO orders(order_id, order_date, order_type, product_id)
VALUES
(2001, '2025-02-15', 'Online', 701),
(2002, '2025-02-16', 'Offline', 701),
(2003, '2025-02-17', 'Wholesale', 701),
(2004, '2025-02-18', 'Online', 702),
(2005, '2025-02-19', 'Online', 702),
(2006, '2025-02-20', 'Offline', 703);

-- find the maximum soled product
select product_id, count(product_id) as total_count
from orders
group by product_id
limit 1;

