SELECT (
    SELECT DISTINCT salary AS SecondHighestSalary
    FROM employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary
