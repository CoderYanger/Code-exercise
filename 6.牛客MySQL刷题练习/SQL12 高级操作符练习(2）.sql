-- 题目：现在运营想要找到学校为北大或GPA在3.7以上(不包括3.7)的用户进行调研，请你取出相关数据（使用OR实现）
select device_id, gender,age,university,gpa from user_profile where university="北京大学" or gpa>3.7