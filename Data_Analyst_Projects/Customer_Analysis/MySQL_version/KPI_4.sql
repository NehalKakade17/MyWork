CREATE TABLE customers (
    customer_id TEXT,
    customer_unique_id TEXT,
    customer_zip_code_prefix INT,
    customer_city TEXT,
    customer_state TEXT
);
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/olist_customers_dataset.csv'
INTO TABLE customers
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

SELECT DISTINCT customer_city 
FROM customers 
LIMIT 20;

-- KPI 4 :- Average payment and price values for sao paulo customers


SELECT 
AVG(oi.order_price) AS Avg_Price,
AVG(op.order_payment) AS Avg_Payment
FROM orders o
JOIN customers c
    ON o.customer_id = c.customer_id

JOIN (
    SELECT order_id, SUM(price) AS order_price
    FROM order_items
    GROUP BY order_id
) oi
    ON o.order_id = oi.order_id

JOIN (
    SELECT order_id, SUM(payment_value) AS order_payment
    FROM order_payments
    GROUP BY order_id
) op
    ON o.order_id = op.order_id

WHERE c.customer_city = 'sao paulo';

-- Customers from São Paulo spend approximately ₹140.9 per order, while the average product value is around ₹124.3, indicating additional costs like shipping or taxes included in payments.