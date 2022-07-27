# Write your MySQL query statement below
SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT id, num, LEAD(num) OVER (ORDER BY id) AS next, LAG(num) OVER (ORDER BY id) AS prev
    FROM logs
) a
WHERE num = next AND num = prev
