# Write your MySQL query statement below
WITH senior AS (
    SELECT employee_id, SUM(salary) OVER (ORDER BY salary ASC) AS sm
    FROM candidates
    WHERE experience = 'Senior'
),
junior AS (
    SELECT employee_id, SUM(salary) OVER (ORDER BY salary ASC) AS sm
    FROM candidates
    WHERE experience = 'Junior'
)
SELECT employee_id
FROM senior
WHERE sm <= 70000
UNION
SELECT employee_id
FROM junior
WHERE sm <= (SELECT 70000 - IFNULL(MAX(sm), 0) FROM senior WHERE sm <= 70000)
;
