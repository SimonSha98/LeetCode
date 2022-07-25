# Write your MySQL query statement below
WITH rk AS (
    SELECT student_id, department_id, RANK() OVER (PARTITION BY department_id ORDER BY mark DESC) AS mrk
    FROM students
),
dep AS (
    SELECT department_id, COUNT(student_id) AS ct
    FROM students
    GROUP BY department_id
)
SELECT rk.student_id, dep.department_id, ROUND(IFNULL((mrk - 1)*100/(ct-1), 0), 2) AS percentage
FROM rk JOIN dep
ON rk.department_id = dep.department_id
;
