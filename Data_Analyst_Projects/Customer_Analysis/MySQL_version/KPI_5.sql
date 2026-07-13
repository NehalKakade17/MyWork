-- KPI 5 :- Relationship between shipping days and review scores
SELECT 
r.review_score,
AVG(DATEDIFF(o.order_delivered_dt, o.order_purchase_dt)) AS Avg_Shipping_Days
FROM orders o
JOIN order_reviews r
ON o.order_id = r.order_id
WHERE 
o.order_delivered_dt IS NOT NULL
GROUP BY r.review_score
ORDER BY r.review_score;

-- Faster deliveries lead to higher customer satisfaction, while delays significantly reduce review scores.
-- Customers who received orders in ~10–11 days gave 5-star ratings, whereas deliveries taking ~21 days resulted in 1-star reviews, showing delivery speed is a critical driver of customer experience.