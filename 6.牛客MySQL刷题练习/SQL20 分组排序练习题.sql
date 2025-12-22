-- 题目：现在运营想要查看不同大学的用户平均发帖情况，并期望结果按照平均发帖情况进行升序排列，请你取出相应数据。
select university,avg(question_cnt) avg_question_cnt from user_profile group by university order by avg(question_cnt) asc