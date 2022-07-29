# Write your MySQL query statement below
WITH hi AS (
    SELECT e.id, e.name, d.id AS Department, d.name AS dep_name, salary, e.departmentId, RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rk
    FROM employee e JOIN department d
    ON e.departmentId = d.id
)
SELECT dep_name AS Department, name AS Employee, salary
FROM hi
WHERE rk = 1
;
