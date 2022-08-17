# Write your MySQL query statement below
WITH pn AS (
    SELECT id, student, LAG(student) OVER (ORDER BY id) AS prev, LEAD(student) OVER (ORDER BY id) AS next
    FROM seat
)
SELECT p.id, CASE WHEN MOD(p.id, 2) = 1 THEN IFNULL(p.next, p.student) ELSE p.prev END AS student
FROM pn p
