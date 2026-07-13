CREATE TABLE order_items (
    order_id TEXT,
    order_item_id INT,
    product_id TEXT,
    seller_id TEXT,
    shipping_limit_date TEXT,
    price DOUBLE,
    freight_value DOUBLE
);
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/olist_order_items_dataset.csv'
INTO TABLE order_items
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

CREATE TABLE products (
    product_id TEXT,
    product_category_name TEXT
);
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/olist_products_dataset.csv'
INTO TABLE products
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(product_id, product_category_name, @col3, @col4, @col5, @col6, @col7, @col8, @col9);

-- KPI 3 - Average number of days taken for delivery of pet shop items to customer --
 
SELECT 
AVG(DATEDIFF(o.order_delivered_dt, o.order_purchase_dt)) AS Avg_Delivery_Days
FROM orders o
JOIN order_items oi
ON o.order_id = oi.order_id
JOIN products p
ON oi.product_id = p.product_id
WHERE 
p.product_category_name = 'pet_shop'
AND o.order_delivered_dt IS NOT NULL;

-- Pet shop category orders take approximately 11–12 days on average for delivery, indicating moderate delivery timelines.
-- Delivery time is relatively consistent and can be optimized further to improve customer satisfaction, especially for time-sensitive pet products.