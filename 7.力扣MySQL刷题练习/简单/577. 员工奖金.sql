# Write your MySQL query statement below
select e.name,b.bonus from employee e left join bonus b on 
e.empid=b.empid where b.bonus<1000 or b.bonus is null
-- on 是左连接的连接条件
-- where是全局筛选条件，对连接的结果进行二次过滤