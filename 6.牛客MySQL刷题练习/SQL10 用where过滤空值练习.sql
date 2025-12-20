-- 题目：现在运营想要对用户的年龄分布开展分析，在分析时想要剔除没有获取到年龄的用户，请你取出所有年龄值不为空的用户的设备ID，性别，年龄，学校的信息。
-- select device_id,gender,age,university from user_profile where not age="NULL"
select device_id,gender,age,university from user_profile where not age=""
-- 两种代码都可以