# Write your MySQL query statement below
SELECT s.salesperson_id, s.name, SUM(IFNULL(s2.price, 0)) AS total
FROM salesperson s LEFT JOIN customer c
ON s.salesperson_id = c.salesperson_id
LEFT JOIN sales s2
ON c.customer_id = s2.customer_id
GROUP BY s.salesperson_id
