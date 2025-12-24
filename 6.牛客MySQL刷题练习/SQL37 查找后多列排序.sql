-- 题目：现在运营想要取出用户信息表中的device_id、年龄和gpa数据，并先按照gpa升序排序，再按照年龄升序排序输出，请取出相应数据。
select device_id,gpa,age from user_profile order by gpa asc , age asc
-- 先后排序一个order by就行