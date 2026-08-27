# Write your MySQL query statement below
-- select s.name from salesperson s left join company c,orders o on o.com_id=c.com_id and o.sales_id=s.sales_id and c.name is not in red 
-- 语法错误：错在了左连接不能一次性连接三个表
-- select s.name from salesperson s left join orders o on o.sales_id=s.sales_id left join company c on o.com_id=c.com_id and c.name='red' where o.sales_id is null
-- 逻辑错误：错在了Alex没有任何订单也被筛出来了
select s.name from SalesPerson s where s.sales_id not in (select o.sales_id from Orders o join Company c on o.com_id=c.com_id and c.name='red')
-- 不能用左连接，应该用内连接来确保只有二者都有匹配记录且c为red才被选中