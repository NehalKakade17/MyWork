CREATE TABLE order_reviews (
    review_id TEXT,
    order_id TEXT,
    review_score INT,
    review_creation_date TEXT,
    review_answer_timestamp TEXT
);
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/olist_order_reviews_dataset.csv'
INTO TABLE order_reviews
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

SELECT review_score, COUNT(*) 
FROM order_reviews
GROUP BY review_score;
SELECT payment_type, COUNT(*) 
FROM order_payments
GROUP BY payment_type;
-- KPI 2 :- Review score 5 and payment type as credit card count
SELECT 
COUNT(DISTINCT o.order_id) AS Total_Orders
FROM orders o
JOIN order_payments p
ON o.order_id = p.order_id
JOIN order_reviews r
ON o.order_id = r.order_id
WHERE 
r.review_score = 5
AND p.payment_type = 'credit_card';

-- A large number of highly satisfied customers preferred credit card payments.