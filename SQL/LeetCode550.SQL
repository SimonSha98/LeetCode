WITH 2nd AS (
    SELECT player_id, DATEDIFF(event_date, MIN(event_date) OVER (PARTITION BY player_id ORDER BY event_date)) AS mi
    FROM activity
)
SELECT ROUND(SUM(CASE WHEN mi = 1 THEN 1 ELSE NULL END)/COUNT(DISTINCT player_id), 2) AS fraction
FROM 2nd
