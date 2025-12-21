-- 题目：运营想要知道复旦大学学生gpa最高值是多少，请你取出相应数据
select MAX(gpa) gpa from user_profile where university="复旦大学"
-- 聚合函数写前面