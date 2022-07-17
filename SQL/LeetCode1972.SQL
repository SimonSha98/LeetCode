# Write your MySQL query statement below
WITH cal AS (
    SELECT caller_id, recipient_id, call_time
    FROM calls
    UNION ALL
    SELECT recipient_id, caller_id, call_time
    FROM calls
),
caller AS (
    SELECT caller_id, FIRST_VALUE(recipient_id) OVER (PARTITION BY caller_id, DATE(call_time) ORDER BY call_time) AS fir,
                      LAST_VALUE(recipient_id) OVER (PARTITION BY caller_id, DATE(call_time) ORDER BY call_time RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS las
    FROM cal
)
SELECT DISTINCT caller_id AS user_id
FROM caller
WHERE fir = las
;
