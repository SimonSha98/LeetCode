# Write your MySQL query statement below
WITH friend AS (
    SELECT user1_id, user2_id
    FROM friendship
    UNION
    SELECT user2_id, user1_id
    FROM friendship
)
SELECT f.user1_id AS user_id, l.page_id, COUNT(*) AS friends_likes
FROM friend f LEFT JOIN likes l
ON f.user2_id = l.user_id
LEFT JOIN likes l1
ON f.user1_id = l1.user_id AND l.page_id = l1.page_id
WHERE l1.page_id IS NULL
GROUP BY f.user1_id, l.page_id
