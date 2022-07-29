# Write your MySQL query statement below
WITH e AS (
    SELECT a.name, COUNT(*) AS ct
    FROM employee a JOIN employee b
    ON b.managerId = a.id
    GROUP BY a.id
)
SELECT DISTINCT name
FROM e
WHERE ct >= 5
;
