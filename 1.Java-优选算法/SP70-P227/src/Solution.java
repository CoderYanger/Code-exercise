import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-16
 * Time: 19:25
 */
class Solution {
    //227. 基本计算器 II
    public int calculate(String s) {//课后自己按照记忆一遍写出来了
        Deque<Integer> stack=new ArrayDeque<>();
        //要写成ArrayDeque（它是实现了Deque接口的类），而Deque是接口，不能实例化
        char op='+';int i=0,n=s.length();
        char[] ss=s.toCharArray();
        while(i<n){
            if(ss[i]==' ')i++;
            else if(!isOperator(ss[i])){
                int tmp=0;
                while(i<n&&ss[i]>='0'&&ss[i]<='9'){
                    tmp=tmp*10+(int)(ss[i]-'0');
                    i++;
                }
                if(op=='+') stack.push(tmp);
                else if(op=='-') stack.push(-tmp);
                else if(op=='*') stack.push(stack.pop()*tmp);
                else stack.push(stack.pop()/tmp);
            }else{
                op=ss[i];
                i++;
            }
        }
        int ret=0;
        while(!stack.isEmpty()) ret+=stack.pop();
        return ret;
    }
    public boolean isOperator(char ch){
        return (ch=='+'||ch=='-'||ch=='*'||ch=='/');
    }
}