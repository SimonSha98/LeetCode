# Write your MySQL query statement below
WITH RECURSIVE mo AS (
    SELECT 1 AS month
    UNION ALL
    SELECT month + 1 AS month
    FROM mo
    WHERE month < 10
)
SELECT month, ROUND(SUM(CASE WHEN ride_distance IS NULL THEN 0 ELSE ride_distance END)/3, 2) AS average_ride_distance, ROUND(SUM(CASE WHEN ride_duration IS NULL THEN 0 ELSE ride_duration END)/3, 2) AS average_ride_duration
FROM rides r JOIN acceptedrides a
ON r.ride_id = a.ride_id
RIGHT JOIN mo
ON MONTH(requested_at) >= month AND MONTH(requested_at) < month + 3 AND YEAR(requested_at) = 2020
GROUP BY month
ORDER BY month
