-- 题目描述
# 在一张contacts表中，存储了用户的联系信息。请查询出所有符合以下条件的电话号码，并按id升序输出所有字段：
# 电话号码必须是 10 位数字。
# 电话号码的第一位不能以 0 开头。
# 电话号码的格式可以是连续的 10 位数字，或以-分隔的格式（如123-456-7890）。
-- select id,name,phone_number from contacts where phone_number not in (like "0%" and like ___-____-___)
select * from contacts 
where phone_number regexp '^[1-9][0-9]{9}$'
or phone_number regexp '^[1-9][0-9]{2}-[0-9]{3}-[0-9]{4}$';
-- 这个确实没啥印象了