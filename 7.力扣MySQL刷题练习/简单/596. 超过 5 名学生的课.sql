# Write your MySQL query statement below
select class from courses group by class having count(distinct student)>=5
-- 聚合函数的使用：1.用于全局（写前面）2.跟在group by后面
-- 每个学生多次选同一门课程，也只能算一个学生，所以加distinct