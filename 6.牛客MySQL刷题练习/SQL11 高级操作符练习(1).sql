-- 题目：现在运营想要找到male且GPA在3.5以上(不包括3.5)的用户进行调研，请你取出相关数据。
select device_id,gender,age,university,gpa from user_profile where gender="male" and gpa>3.5