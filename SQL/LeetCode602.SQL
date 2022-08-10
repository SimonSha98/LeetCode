WITH req AS (
    SELECT requester_id AS id, COUNT(*) AS ct
    FROM RequestAccepted
    GROUP BY requester_id
    UNION ALL
    SELECT accepter_id AS id, COUNT(*) AS ct
    FROM RequestAccepted
    GROUP BY accepter_id
)
SELECT r.id, SUM(r.ct) AS num
FROM req r
GROUP BY r.id
ORDER BY num DESC
LIMIT 1
;
