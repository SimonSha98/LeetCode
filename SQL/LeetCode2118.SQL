# Write your MySQL query statement below
WITH cte AS (
    SELECT power, CONCAT(CASE WHEN factor > 0 THEN CONCAT('+', factor) ELSE factor END, CASE WHEN power > 1  THEN CONCAT('X^', power) WHEN power = 1 THEN 'X' ELSE '' END) AS eq
    FROM terms
)
SELECT CONCAT(GROUP_CONCAT(eq ORDER BY power DESC SEPARATOR ''), '=0') AS equation
FROM cte
;
