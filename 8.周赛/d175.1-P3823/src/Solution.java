import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 13:00
 */
class Solution {
    //3823. 反转一个字符串里的字母后反转特殊字符
    public String reverseByType(String s) {
        //记录小写字母的下标
        List<Integer> list1=new ArrayList<>();
        //记录特殊字符的下标
        List<Integer> list2=new ArrayList<>();
        //拼接小写字母
        StringBuffer sb1=new StringBuffer();
        //拼接特殊字符
        StringBuffer sb2=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='z'&&s.charAt(i)>='a'){
                list1.add(i);
                sb1.append(s.charAt(i));
            }else{
                list2.add(i);
                sb2.append(s.charAt(i));
            }
        }
        sb1.reverse();
        sb2.reverse();
        //还原
        char[] ch=new char[s.length()];
        for(int i=0;i<list1.size();i++)
            ch[list1.get(i)]=sb1.charAt(i);
        for(int i=0;i<list2.size();i++)
            ch[list2.get(i)]=sb2.charAt(i);
        return new String(ch);
    }
}