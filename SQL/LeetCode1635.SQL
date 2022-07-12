# Write your MySQL query statement below
WITH RECURSIVE mo AS (
    SELECT 1 AS month
    UNION ALL
    SELECT month + 1 AS month
    FROM mo
    WHERE month < 12
),
dr AS (
    SELECT month, COUNT(d.driver_id) AS active_drivers
    FROM mo LEFT JOIN drivers d
    ON month >= MONTH(d.join_date) AND YEAR(d.join_date) = 2020 OR YEAR(d.join_date) < 2020
    GROUP BY month
),
ride AS (
    SELECT month, COUNT(r.ride_id) AS accepted_rides
    FROM rides r JOIN AcceptedRides a
    ON r.ride_id = a.ride_id
    RIGHT JOIN mo
    ON month = MONTH(r.requested_at) AND YEAR(r.requested_at) = 2020
    GROUP BY month
)
SELECT dr.month, active_drivers, accepted_rides
FROM dr JOIN ride
ON dr.month = ride.month
ORDER BY month
;
