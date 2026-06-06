CREATE DATABASE crm_project;
USE crm_project;
SELECT * FROM lead_table LIMIT 10;

-- KPI 1 : Total Leads --
SELECT COUNT(*) AS total_leads FROM lead_table;

-- KPI 2 : Converted Accounts --
SELECT COUNT(*) AS converted_accounts FROM lead_table WHERE Converted = 'TRUE';

-- KPI 3 : Converted Opportunities --
SELECT COUNT(*) AS converted_opportunities FROM lead_table WHERE TRIM(`Converted Opportunity ID`) <> '';

-- KPI 4 : Conversion Rate --
SELECT 
(
    SUM(CASE WHEN Converted = 'TRUE' THEN 1 ELSE 0 END) / COUNT(*)
) * 100 AS conversion_rate FROM lead_table;

-- KPI 5 : Lead By Source --
SELECT `Lead Source`, COUNT(*) AS total_leads FROM lead_table GROUP BY `Lead Source` ORDER BY total_leads DESC;

-- KPI 6 : Lead By Industry --
SELECT industry, COUNT(*) AS total_leads FROM lead_table GROUP BY industry ORDER BY total_leads DESC;

-- KPI 7 : Lead By Stage --
SELECT coalesce(o.stage,'No opportunity') AS stage, COUNT(*) AS total_leads FROM lead_table l LEFT JOIN oppertuninty_table o ON 
l.`Converted Opportunity ID` = o.`Opportunity ID` GROUP BY stage order by total_leads DESC;

-- KPI 8 : Expected Amount from Converted Accounts --
SELECT SUM(
CAST(REPLACE(REPLACE(o.`Expected Amount`,'$',''),',','')AS DECIMAL(15,2))
) AS expected_revenue
FROM lead_table l LEFT JOIN oppertuninty_table o ON TRIM(l.`Converted Opportunity ID`) = TRIM(o.`Opportunity ID`);