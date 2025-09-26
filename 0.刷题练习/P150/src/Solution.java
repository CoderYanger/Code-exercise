import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-16
 * Time: 19:25
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String ch:tokens){
            if(!isOperator(ch)){
                int x=Integer.parseInt(ch);//parseInt将字符串解析为指定的int
                stack.push(x);
            }else{
                //注意先出来的是右操作数
                int val2=stack.pop();
                int val1=stack.pop();
                switch(ch){
                    case "+":stack.push(val1+val2);
                        break;
                    case "-":stack.push(val1-val2);
                        break;
                    case "*":stack.push(val1*val2);
                        break;
                    case "/":stack.push(val1/val2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public boolean isOperator(String ch){
        return (ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/"));
    }
}