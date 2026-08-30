# Write your MySQL query statement below
-- datediff("2019-07-27",activity_date)为0时，说明当天是2019-07-27
-- session_id=2：咱买东西，咱跟id为2的商家进行了一次会话
select activity_date as day,count(distinct user_id) as active_users
from Activity where datediff("2019-07-27",activity_date) between 0 and 29
group by activity_date