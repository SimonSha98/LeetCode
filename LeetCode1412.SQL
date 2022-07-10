WITH hi_lo AS (
    SELECT student_id, RANK() OVER (PARTITION BY exam_id ORDER BY score) as rk
    FROM exam
    UNION ALL
    SELECT student_id, RANK() OVER (PARTITION BY exam_id ORDER BY score DESC) as rk
    FROM exam
)
SELECT DISTINCT s.student_id, s.student_name
FROM student s
JOIN exam e
ON s.student_id = e.student_id
LEFT JOIN (SELECT student_id FROM hi_lo WHERE rk = 1) a
ON s.student_id = a.student_id
WHERE a.student_id IS NULL
ORDER BY s.student_id
