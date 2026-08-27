# Write your MySQL query statement below
select x,y,z,if(x+y>z and x+z>y and y+z>x,'Yes','No') as triangle from Triangle ;
-- 语法：IF(condition, value_if_true, value_if_false)
-- condition：要判断的条件（如字段比较、数值判断等，结果为 TRUE 或 FALSE）；
-- value_if_true：条件为 TRUE 时返回的值；
-- value_if_false：条件为 FALSE 时返回的值。