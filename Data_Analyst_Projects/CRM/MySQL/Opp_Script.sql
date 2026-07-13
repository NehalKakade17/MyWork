-- KPI 1 : Expected Amount --
SELECT SUM(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS total_expected_amount FROM oppertuninty_table;

-- KPI 2 : Active Opportunities --
SELECT COUNT(`Opportunity ID`) AS active_opportunities FROM oppertuninty_table WHERE Closed = 'False';

-- KPI 3 : Conversion Rate --
SELECT (
    SUM(CASE WHEN Won = 'True' THEN 1 ELSE 0 END) / COUNT(`Opportunity ID`)
) * 100 AS conversion_rate
FROM oppertuninty_table;

-- KPI 4 : Win Rate --
SELECT (
    SUM(CASE WHEN Won = 'True' THEN 1 ELSE 0 END) / SUM(CASE WHEN Closed = 'True' THEN 1 ELSE 0 END)
) * 100 AS win_rate
FROM oppertuninty_table;

-- KPI 5 : Loss Rate --
SELECT (
    SUM(CASE 
            WHEN Closed = 'True' AND Won = 'False' THEN 1 
            ELSE 0 
        END) / COUNT(`Opportunity ID`)
) * 100 AS loss_rate
FROM oppertuninty_table;

-- KPI 6 : Trend Analysis --
ALTER TABLE oppertuninty_table ADD COLUMN created_date_clean DATETIME;
SET SQL_SAFE_UPDATES = 0;
UPDATE oppertuninty_table SET created_date_clean = STR_TO_DATE(`Created Date`, '%m/%d/%Y %H:%i');
SELECT 
    YEAR(created_date_clean) AS year,
    MONTHNAME(created_date_clean) AS month_name,
    COUNT(`Opportunity ID`) AS total_opportunities
FROM oppertuninty_table
GROUP BY 
    YEAR(created_date_clean),
    MONTH(created_date_clean),
    MONTHNAME(created_date_clean)
ORDER BY 
    YEAR(created_date_clean),
    MONTH(created_date_clean);
    
-- KPI 7 : Expected vs Forecast --
WITH monthly_data AS (
	SELECT 
        YEAR(created_date_clean) AS year,
		MONTH(created_date_clean) AS month_num,
		MONTHNAME(created_date_clean) AS month_name,
		SUM(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS monthly_expected_amount,
		SUM(
            CASE 
                WHEN `Forecast Q Commit` = 'TRUE'
                THEN 1
                ELSE 0
            END
        ) AS monthly_forecast_commit
	FROM oppertuninty_table GROUP BY YEAR(created_date_clean), MONTH(created_date_clean), MONTHNAME(created_date_clean))
SELECT year, month_name, monthly_expected_amount, SUM(monthly_expected_amount) OVER ( ORDER BY year, month_num) AS running_expected_amount,
monthly_forecast_commit, SUM(monthly_forecast_commit) OVER ( ORDER BY year, month_num) AS running_forecast_commit
FROM monthly_data;

-- KPI 8 : Active vs Total Opportunities --
WITH monthly_data AS (
	SELECT YEAR(created_date_clean) AS year, MONTH(created_date_clean) AS month_num, MONTHNAME(created_date_clean) AS month_name,
		COUNT(`Opportunity ID`) AS monthly_total_opportunities,
		SUM(
            CASE
                WHEN Closed = 'FALSE'
                THEN 1
                ELSE 0
            END
        ) AS monthly_active_opportunities
	FROM oppertuninty_table GROUP BY YEAR(created_date_clean), MONTH(created_date_clean), MONTHNAME(created_date_clean))
SELECT year, month_name, monthly_total_opportunities, SUM(monthly_total_opportunities) OVER (ORDER BY year, month_num) AS running_total_opportunities,
monthly_active_opportunities, SUM(monthly_active_opportunities) OVER ( ORDER BY year, month_num) AS running_active_opportunities
FROM monthly_data;

-- KPI 9 : Closed Won vs Total Opportunities --
WITH monthly_data AS (
	SELECT YEAR(created_date_clean) AS year, MONTH(created_date_clean) AS month_num, MONTHNAME(created_date_clean) AS month_name,
		COUNT(`Opportunity ID`) AS monthly_total_opportunities,
		SUM(
            CASE
                WHEN Won = 'TRUE'
                THEN 1
                ELSE 0
            END
        ) AS monthly_won_opportunities
	FROM oppertuninty_table GROUP BY YEAR(created_date_clean), MONTH(created_date_clean), MONTHNAME(created_date_clean))
SELECT year, month_name, monthly_total_opportunities,SUM(monthly_total_opportunities) OVER (ORDER BY year, month_num) AS running_total_opportunities,
monthly_won_opportunities, SUM(monthly_won_opportunities) OVER ( ORDER BY year, month_num) AS running_won_opportunities
FROM monthly_data;

-- KPI 10 : Closed Won vs Total Closed --
WITH monthly_data AS (
	SELECT YEAR(created_date_clean) AS year, MONTH(created_date_clean) AS month_num, MONTHNAME(created_date_clean) AS month_name,
		SUM(
            CASE
                WHEN Closed = 'TRUE'
                THEN 1
                ELSE 0
            END
        ) AS monthly_closed_opportunities,
		SUM(
            CASE
                WHEN Won = 'TRUE'
                THEN 1
                ELSE 0
            END
        ) AS monthly_won_opportunities
	FROM oppertuninty_table GROUP BY YEAR(created_date_clean), MONTH(created_date_clean), MONTHNAME(created_date_clean))
SELECT year, month_name, monthly_closed_opportunities, SUM(monthly_closed_opportunities) OVER ( ORDER BY year, month_num ) AS running_closed_opportunities,
monthly_won_opportunities, SUM(monthly_won_opportunities) OVER ( ORDER BY year, month_num ) AS running_won_opportunities
FROM monthly_data;

-- KPI 11 : Expected Amount by Opportunity Type --
SELECT `Opportunity Type`, COUNT(`Opportunity ID`) AS total_opportunities,
SUM(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS total_expected_amount,
AVG(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS avg_expected_amount 
FROM oppertuninty_table GROUP BY `Opportunity Type` ORDER BY total_expected_amount DESC;

-- KPI 12 : Opportunities By Industry --
SELECT Industry, COUNT(`Opportunity ID`) AS total_opportunities,
SUM(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS total_expected_amount,
AVG(CAST(REPLACE(REPLACE(`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))) AS avg_expected_amount
FROM oppertuninty_table GROUP BY Industry ORDER BY total_opportunities DESC;