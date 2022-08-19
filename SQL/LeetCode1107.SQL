# Write your MySQL query statement below
WITH filter AS (
    SELECT user_id, activity, activity_date, RANK() OVER (PARTITION BY user_id ORDER BY activity_date) AS rk
    FROM traffic
    WHERE activity = 'login'
)
SELECT activity_date AS login_date, COUNT(DISTINCT user_id) AS user_count
FROM filter
WHERE rk = 1 AND DATEDIFF('2019-06-30', activity_date) <= 90
GROUP BY activity_date
