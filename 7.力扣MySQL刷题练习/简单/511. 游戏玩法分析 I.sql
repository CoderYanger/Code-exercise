# Write your MySQL query statement below
select player_id,min(event_date) as first_login from Activity group by player_id 
-- min直接能找到最小的日期