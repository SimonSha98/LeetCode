# Write your MySQL query statement below
WITH same_value AS (
    SELECT DISTINCT i1.pid
    FROM insurance i1 JOIN insurance i2
    ON i1.tiv_2015 = i2.tiv_2015 AND i1.pid != i2.pid
),
same_city AS (
    SELECT DISTINCT i1.pid
    FROM insurance i1 JOIN insurance i2
    ON i1.lat = i2.lat AND i1.lon = i2.lon AND i1.pid != i2.pid
)
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM insurance
WHERE pid IN (SELECT * FROM same_value) AND pid NOT IN (SELECT * FROM same_city)
;
