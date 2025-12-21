-- 题目：现在运营想查看所有大学中带有"北京"的用户的信息(device_id,age,university)，请你取出相应数据。
-- select device_id,age,university from user_profile where university="北京%"
-- 上面那个是一开始写的错误的代码
select device_id,age,university from user_profile where university like "北京%"