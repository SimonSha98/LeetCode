# Write your MySQL query statement below
WITH cte AS (
    SELECT player_id, match_day, result, ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY match_day) AS rk
    FROM matches
),
temp AS (
    SELECT player_id, rk - ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY match_day) AS group_id
    FROM cte
    WHERE result = 'Win'
),
streak AS (
    SELECT player_id, COUNT(*) AS ct
    FROM temp
    GROUP BY player_id, group_id
)
SELECT DISTINCT m.player_id, IFNULL(MAX(ct), 0) AS longest_streak
FROM matches m LEFT JOIN streak s
ON m.player_id = s.player_id
GROUP BY m.player_id
