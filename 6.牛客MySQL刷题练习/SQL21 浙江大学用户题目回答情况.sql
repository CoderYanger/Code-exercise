-- 题目：现在运营想要查看所有来自浙江大学的用户题目回答明细情况，请你取出相应数据
select q.device_id,question_id,result from question_practice_detail q,user_profile u where q.device_id= u.device_id and u.university ="浙江大学" order by question_id asc
-- 因为device_id有重复的，MySQL不知道我要选择的是哪一个，所以要明确写出来，加上q.