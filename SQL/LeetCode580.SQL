# Write your MySQL query statement below
SELECT dept_name, COUNT(student_name) AS student_number
FROM department d LEFT JOIN student s
ON s.dept_id = d.dept_id
GROUP BY d.dept_id
ORDER BY student_number DESC, dept_name
