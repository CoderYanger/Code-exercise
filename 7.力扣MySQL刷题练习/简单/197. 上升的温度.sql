# Write your MySQL query statement below
select w1.id as id from Weather w1,Weather w2 where w1.Temperature>w2.Temperature and datediff(w1.recordDate,w2.recordDate)=1
-- datediff(w1.recordDate,w2.recordDate)=1是正数代表前面日期大（10-14）后面小（10-13）