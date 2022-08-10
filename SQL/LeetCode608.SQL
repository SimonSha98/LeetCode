WITH p AS (
    SELECT p_id
    FROM tree
    WHERE p_id IS NOT NULL
)
SELECT id, CASE WHEN p_id IS NULL THEN 'Root' WHEN p_id IS NOT NULL AND id IN (SELECT * FROM p) THEN 'Inner' ELSE 'Leaf' END AS type
FROM tree
