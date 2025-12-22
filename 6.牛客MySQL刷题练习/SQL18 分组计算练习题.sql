-- 题目：现在运营想要对每个学校不同性别的用户活跃情况和发帖数量进行分析，请分别计算出每个学校每种性别的用户数、30天内平均活跃天数和平均发帖数量。
select gender,university,count(id) user_num,AVG(active_days_within_30) avg_active_day,AVG(question_cnt) avg_question_cnt from user_profile group by university, gender order by gender asc,university asc
-- select gender,university,count(id) user_num,AVG(active_days_within_30) avg_active_day,AVG(question_cnt) avg_question_cnt from user_profile group by university, gender order by having gender asc,university asc
-- 这里having后面只能接筛选条件，而不能接排序条件,所以上面这个是错误的