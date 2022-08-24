WITH act AS (
    SELECT event_type, SUM(occurences)/COUNT(*) AS av
    FROM events
    GROUP BY event_type
)
SELECT business_id
FROM (
    SELECT e.business_id, COUNT(*) AS ct
    FROM events e JOIN act a
    ON e.event_type = a.event_type
    WHERE e.occurences > a.av
    GROUP BY e.business_id
) s
WHERE ct > 1
