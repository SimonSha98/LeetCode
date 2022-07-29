# Write your MySQL query statement below
SELECT name
FROM (
    SELECT name, COUNT(*) AS ct
    FROM candidate c JOIN vote v
    ON c.id = v.candidateId
    GROUP BY c.id
) a
ORDER BY ct DESC LIMIT 1
;
