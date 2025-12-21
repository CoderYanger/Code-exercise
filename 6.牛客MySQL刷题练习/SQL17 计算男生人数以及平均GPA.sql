-- 题目：现在运营想要看一下男性用户有多少人以及他们的平均gpa是多少，用以辅助设计相关活动，请你取出相应数据。
select count(gender) male_num,AVG(gpa)avg_gpa from user_profile where gender="male"