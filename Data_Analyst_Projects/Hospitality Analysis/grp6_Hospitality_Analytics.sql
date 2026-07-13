CREATE DATABASE hotel_analytics;
USE hotel_analytics;
CREATE TABLE dim_date (date VARCHAR(20),mmm_yy VARCHAR(20),week_no VARCHAR(10),day_type VARCHAR(20));
CREATE TABLE dim_hotels (property_id INT,property_name VARCHAR(100),category VARCHAR(50),city VARCHAR(50));
CREATE TABLE dim_rooms (room_id VARCHAR(10),room_class VARCHAR(50));
CREATE TABLE fact_aggregated_bookings (property_id VARCHAR(50),check_in_date VARCHAR(50),room_category VARCHAR(20),successful_bookings VARCHAR(20),
capacity VARCHAR(20));
CREATE TABLE fact_bookings (booking_id VARCHAR(100),property_id VARCHAR(50),booking_date VARCHAR(50),check_in_date VARCHAR(50),checkout_date VARCHAR(50),
no_guests VARCHAR(20),room_category VARCHAR(20),booking_platform VARCHAR(100),ratings_given VARCHAR(20),booking_status VARCHAR(50),revenue_generated VARCHAR(50),
revenue_realized VARCHAR(50),customer_id VARCHAR(50),payment_method VARCHAR(50),stay_duration VARCHAR(20),cancellation_reason VARCHAR(255),is_loyalty_member VARCHAR(20),
country VARCHAR(50),customer_age VARCHAR(20),special_requests VARCHAR(50),discount_applied VARCHAR(50),booking_channel VARCHAR(50));

-- KPI 1 : Total Revenue
SELECT ROUND(SUM(CAST(revenue_realized AS DECIMAL(12,2))),2) AS Total_Revenue FROM fact_bookings;

-- KPI 2 : Total Bookings
SELECT COUNT(*) AS Total_Bookings FROM fact_bookings;

-- KPI 3 : Cancellation Rate
SELECT ROUND( (COUNT(CASE WHEN booking_status='Cancelled' THEN 1 END)*100.0) / COUNT(*),2) AS Cancellation_Rate_Percentage FROM fact_bookings;

-- KPI 4 : Occupancy Rate
SELECT ROUND( SUM(CAST(successful_bookings AS UNSIGNED)) / SUM(CAST(capacity AS UNSIGNED)) *100 ,2) AS Occupancy_Rate FROM fact_aggregated_bookings;

-- KPI 5 : Utilization Capacity
SELECT SUM(CAST(successful_bookings AS UNSIGNED)) AS Utilized_Capacity FROM fact_aggregated_bookings;

-- KPI 6 : Trend Analysis
SELECT DATE(check_in_date) AS stay_date, ROUND(SUM(CAST(revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings
GROUP BY DATE(check_in_date) ORDER BY stay_date;

-- KPI 7 : WeekDay vs Weekend Revenue and Bookings
SELECT d.day_type,ROUND(SUM(CAST(f.revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings f JOIN dim_date d
ON DATE(f.check_in_date) = STR_TO_DATE(d.date,'%d-%b-%y') GROUP BY d.day_type;
SELECT d.day_type, COUNT(*) AS total_bookings FROM fact_bookings f JOIN dim_date d ON DATE(f.check_in_date) = STR_TO_DATE(d.date,'%d-%b-%y')
GROUP BY d.day_type;

-- KPI 8 : Revenue By City and Hotel
SELECT h.city,ROUND(SUM(CAST(f.revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings f JOIN dim_hotels h 
ON f.property_id = h.property_id GROUP BY h.city ORDER BY revenue DESC;
SELECT h.property_name,ROUND(SUM(CAST(f.revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings f JOIN dim_hotels h
ON f.property_id = h.property_id GROUP BY h.property_name ORDER BY revenue DESC;

-- KPI 9 : Class Wise Revenue
SELECT r.room_class, ROUND(SUM(CAST(f.revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings f JOIN dim_rooms r
ON f.room_category = r.room_id GROUP BY r.room_class ORDER BY revenue DESC;

-- KPI 10 : Checked Out/Cancelled/No Show
SELECT booking_status,COUNT(*) AS bookings,ROUND(COUNT(*)*100.0/(SELECT COUNT(*) FROM fact_bookings),2) AS percentage FROM fact_bookings
GROUP BY booking_status;

-- KPI 11 : Weekly Trend
SELECT d.week_no,ROUND(SUM(CAST(f.revenue_realized AS DECIMAL(12,2))),2) AS revenue FROM fact_bookings f JOIN dim_date d
ON DATE(f.check_in_date)=STR_TO_DATE(d.date,'%d-%b-%y') GROUP BY d.week_no ORDER BY d.week_no;
SELECT d.week_no, COUNT(*) AS bookings FROM fact_bookings f JOIN dim_date d ON DATE(f.check_in_date)=STR_TO_DATE(d.date,'%d-%b-%y')
GROUP BY d.week_no ORDER BY d.week_no;
SELECT d.week_no,ROUND(SUM(CAST(a.successful_bookings AS UNSIGNED))*100/SUM(CAST(a.capacity AS UNSIGNED)),2) AS occupancy_rate
FROM fact_aggregated_bookings a JOIN dim_date d ON STR_TO_DATE(a.check_in_date,'%d-%b-%y')=STR_TO_DATE(d.date,'%d-%b-%y')
GROUP BY d.week_no ORDER BY d.week_no;