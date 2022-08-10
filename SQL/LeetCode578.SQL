# Write your MySQL query statement below
WITH sho AS (
    SELECT question_id, COUNT(*) AS ct
    FROM surveylog
    WHERE action = 'show'
    GROUP BY question_id
),
ans AS (
    SELECT question_id, COUNT(*) AS ct
    FROM surveylog
    WHERE action = 'answer'
    GROUP BY question_id
)
SELECT s.question_id AS survey_log
FROM sho s JOIN ans a
ON s.question_id = a.question_id
ORDER BY a.ct/s.ct DESC, s.question_id LIMIT 1
