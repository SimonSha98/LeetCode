# Write your MySQL query statement below
WITH senior AS (
    SELECT experience, salary, SUM(salary) OVER (ORDER BY salary ASC) AS sm
    FROM candidates
    WHERE experience = 'Senior'
),
junior AS (
    SELECT experience, salary, SUM(salary) OVER (ORDER BY salary ASC) AS sm
    FROM candidates
    WHERE experience = 'Junior'
)
SELECT 'Senior' AS experience, COUNT(*) AS accepted_candidates
FROM senior
WHERE sm <= 70000
UNION
SELECT 'Junior' AS experience, COUNT(*) AS accepted_candidates
FROM junior
WHERE sm <= (SELECT 70000 - IFNULL(MAX(sm), 0) FROM senior WHERE sm <= 70000)
;
