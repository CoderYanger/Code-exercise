-- 题目：现在运营想要查看除复旦大学以外的所有用户明细包括的字段有 device_id、gender、age、university，请你取出相应数据
select device_id,gender,age,university from user_profile where not university="复旦大学"