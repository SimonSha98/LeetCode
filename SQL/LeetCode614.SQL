WITH secdeg AS (
    SELECT DISTINCT f1.followee AS fo
    FROM follow f1 JOIN follow f2
    ON f1.followee = f2.follower
)
SELECT fo AS follower, COUNT(*) AS num
FROM secdeg JOIN follow
ON fo = followee
GROUP BY fo
ORDER BY fo
