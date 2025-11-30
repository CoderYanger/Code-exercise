import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-25
 * Time: 23:22
 */
class Solution {
    //自己的思路，但是存在很多错误，注释处是AI找出的错误
    //我想用哈希表记录对应字符是否用过，但是后来通过AI发现不行，因为可以出现相同的字符
    List<String> databases;
    List<String> ret;
    StringBuffer path;
    //Map<Character,Boolean> hash;
    public List<String> letterCombinations(String digits) {
        path=new StringBuffer("");
        //hash=new HashMap<>();
        ret=new ArrayList<>();
        databases=new ArrayList<>();//改正：初始化
        char[] nums=digits.toCharArray();
        //先把数字对应的字符放进顺序表
        for(int i=0;i<nums.length;i++){
            switch(nums[i]){
                //把continue全部用break代替，switch要用break跳出
                case '2':databases.add("abc");break;
                case '3':databases.add("def");break;
                case '4':databases.add("ghi");break;
                case '5':databases.add("jkl");break;
                case '6':databases.add("mno");break;
                case '7':databases.add("pqrs");break;
                case '8':databases.add("tuv");break;
                case '9':databases.add("wxyz");break;
            }
        }
        if(databases.size()==0) return ret;//改正：新添
        // //把hash表全初始化为false
        // for(int i='a';i<='z';i++){
        //     hash.put((char)i,false);
        // }
        dfs(databases,databases.size(),0);//新增组索引，初始为0
        return ret;
    }
    public void dfs(List<String> databases,int n,int index){
        //n组号码对应的字母,新增index索引
        if(path.toString().length()==n){
            ret.add(path.toString());
            return;
        }
        // for(int i=0;i<databases.size();i++){
        //     String t=databases.get(i);
        //只处理当前index对应的组，删除外层循环，避免重复选组
        String t=databases.get(index);
        for(int j=0;j<t.length();j++){
            char ch=t.charAt(j);
            // if(hash.get(ch)==false){//移除哈希表判断，无需限制字符重复使用
            int start=path.length();
            path.append(ch);
            //hash.put(ch,true);
            //dfs(databases,n-1);
            dfs(databases,n,index+1);//用index+1递归下一组
            //回溯
            //hash.put(ch,false);
            path.deleteCharAt(start);
            //}
        }
        //}
    }
}