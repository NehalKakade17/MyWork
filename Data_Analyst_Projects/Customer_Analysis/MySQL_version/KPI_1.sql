SELECT COUNT(*) 
FROM orders o
JOIN order_payments p
ON o.order_id = p.order_id;
ALTER TABLE orders 
ADD COLUMN order_purchase_dt DATETIME,
ADD COLUMN order_delivered_dt DATETIME;
SET SQL_SAFE_UPDATES = 0;
UPDATE orders
SET 
order_purchase_dt = STR_TO_DATE(order_purchase_timestamp, '%Y-%m-%d %H:%i:%s'),
order_delivered_dt = STR_TO_DATE(order_delivered_customer_date, '%Y-%m-%d %H:%i:%s')
WHERE 
order_purchase_timestamp <> ''
AND order_delivered_customer_date <> '';
SELECT 
order_purchase_dt,
DAYOFWEEK(order_purchase_dt) AS day_num
FROM orders
LIMIT 10;
-- KPI 1 :- Weekday vs Weekend Payment Statistics --
SELECT 
    CASE 
        WHEN DAYOFWEEK(o.order_purchase_dt) IN (1,7) THEN 'Weekend'
        ELSE 'Weekday'
    END AS Day_Type,
    
    COUNT(DISTINCT o.order_id) AS Total_Orders,
    
    SUM(p.payment_value) AS Total_Payment,
    
    AVG(p.payment_value) AS Avg_Payment

FROM orders o
JOIN order_payments p
ON o.order_id = p.order_id

GROUP BY Day_Type;
-- Most orders happen on weekdays, while average payment remains almost the same across weekdays and weekends. It indicates stable purchasing behavior regardless of day type. --