# Write your MySQL query statement below
SELECT post_id,
IFNULL(GROUP_CONCAT(DISTINCT topic_id),"Ambiguous!") AS topic
FROM posts a
LEFT JOIN keywords b
ON CONCAT(' ', lower(a.content), ' ') LIKE CONCAT('% ',lower(b.word),' %')
GROUP BY post_id
ORDER BY post_id
