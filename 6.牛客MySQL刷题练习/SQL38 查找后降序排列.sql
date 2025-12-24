-- 题目：现在运营想要取出用户信息表中对应的数据，并先按照gpa降序排列、gpa相同的按照年龄降序排序输出，请取出相应数据。
select device_id,gpa,age from user_profile order by gpa desc ,age desc;