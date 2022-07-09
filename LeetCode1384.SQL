# Write your MySQL query statement below
WITH RECURSIVE all_day AS (
    SELECT MIN(period_start) AS day
    FROM sales
    UNION ALL
    SELECT day + INTERVAL 1 DAY
    FROM all_day
    WHERE day < (SELECT MAX(period_end) FROM sales)
)
SELECT s.product_id, product_name, CAST(YEAR(day) AS CHAR) AS report_year, SUM(average_daily_sales) AS total_amount
FROM product p, sales s, all_day
WHERE p.product_id = s.product_id AND period_start <= day AND period_end >= day
GROUP BY s.product_id, YEAR(day)
ORDER BY s.product_id, YEAR(day)
