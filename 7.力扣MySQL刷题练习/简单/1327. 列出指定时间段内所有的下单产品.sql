# Write your MySQL query statement below
-- join on 写法
select distinct a.product_name,sum(b.unit) as unit
from Products a 
join Orders b 
on a.product_id=b.product_id
where b.order_date 
between '2020-02-01' and '2020-02-29'
group by a.product_id
having unit>=100
order by a.product_id asc
-- 纯where写法
select distinct a.product_name,sum(b.unit) as unit
from Products a,Orders b 
where a.product_id=b.product_id
and b.order_date 
between '2020-02-01' and '2020-02-29'
group by a.product_id
having unit>=100
order by a.product_id asc