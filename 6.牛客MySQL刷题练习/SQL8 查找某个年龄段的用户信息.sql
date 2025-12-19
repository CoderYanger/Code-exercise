-- 题目：现在运营想要针对20岁及以上且23岁及以下的用户开展分析，请你取出满足条件的设备ID、性别、年龄。
select device_id,gender,age from user_profile where age>=20 and age<=23