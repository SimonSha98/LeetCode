# Write your MySQL query statement below
WITH friend AS (
    SELECT user1_id, user2_id
    FROM friendship
    UNION
    SELECT user2_id, user1_id
    FROM friendship
)
SELECT DISTINCT l1.user_id, l2.user_id AS recommended_id
FROM listens l1 JOIN listens l2
ON l1.song_id = l2.song_id AND l1.day = l2.day AND l1.user_id <> l2.user_id
LEFT JOIN friend
ON user1_id = l1.user_id AND user2_id = l2.user_id
WHERE user1_id IS NULL
GROUP BY l1.user_id, l2.user_id, l1.day
HAVING COUNT(DISTINCT l1.song_id) >= 3
;
