SELECT MIN(ROUND(dis, 2)) AS shortest
FROM (
    SELECT SQRT((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)) AS dis
    FROM point2d p1 JOIN point2d p2
    ON p1.x <> p2.x OR p1.y <> p2.y
) a
