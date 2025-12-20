-- 题目：现在运营想要找到学校为北大、复旦和山大的同学进行调研，请你取出相关数据。
-- select device_id,gender,age,university,gpa from user_profile where in(university="北京大学" or university= "复旦大学" or university="山东大学")
select device_id,gender,age,university,gpa from user_profile where university in("北京大学","复旦大学","山东大学")
-- 当时写法写错了