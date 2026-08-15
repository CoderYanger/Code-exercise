# Write your MySQL query statement below
select t1.name as Employee from Employee t1, Employee t2 where t1.managerId=t2.id and t1.salary>t2.salary 