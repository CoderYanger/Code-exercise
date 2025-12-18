-- 题目：现在运营想要针对24岁以上的用户开展分析，请你取出满足条件的设备ID、性别、年龄、学校。
select device_id,gender,age,university from user_profile where age>24