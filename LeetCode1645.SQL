# Write your MySQL query statement below
WITH RECURSIVE mo AS (
    SELECT 1 AS month
    UNION ALL
    SELECT month + 1 AS month
    FROM mo
    WHERE month < 12
),
acc AS ( # driver accepted at least one ride during the month in 2020
    SELECT month, COUNT(DISTINCT driver_id) AS working
    FROM rides r JOIN acceptedrides a
    ON r.ride_id = a.ride_id
    RIGHT JOIN mo
    ON month = MONTH(r.requested_at) AND YEAR(r.requested_at) = 2020
    GROUP BY month
),
avail AS ( # available drivers that month
    SELECT month, COUNT(d.driver_id) AS driver
    FROM mo LEFT JOIN drivers d
    ON month >= MONTH(d.join_date) AND YEAR(d.join_date) = 2020 OR YEAR(d.join_date) < 2020
    GROUP BY month
)
SELECT acc.month, ROUND(CASE WHEN driver = 0 THEN 0 ELSE working/driver*100 END, 2) AS working_percentage
FROM acc JOIN avail
ON acc.month = avail.month
ORDER BY acc.month
;
