# Write your MySQL query statement below
WITH RECURSIVE sub AS (
    SELECT 1 AS num
    UNION ALL
    SELECT num + 1 AS num
    FROM sub
    WHERE num < 20
),
all_task AS (
    SELECT task_id, num AS subtask_id
    FROM tasks JOIN sub
    ON num <= subtasks_count
)
SELECT a.task_id, a.subtask_id
FROM all_task a LEFT JOIN executed e
ON a.task_id = e.task_id AND a.subtask_id = e.subtask_id
WHERE e.subtask_id IS NULL
;
