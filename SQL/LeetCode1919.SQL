# Write your MySQL query statement below
SELECT DISTINCT user1_id, user2_id
FROM listens l1 JOIN listens l2
ON l1.user_id <> l2.user_id AND l1.day = l2.day AND l1.song_id = l2.song_id
JOIN friendship
ON l1.user_id = user1_id AND l2.user_id = user2_id
GROUP BY l1.user_id, l2.user_id, l1.day
HAVING COUNT(DISTINCT l1.song_id) >= 3
;
