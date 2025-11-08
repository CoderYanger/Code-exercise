import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-16
 * Time: 20:35
 */
class Solution {
    public String decodeString(String s) {
        //自己的思路（大致正确）后续找AI帮忙找bug完成的
        Deque<Integer> stackint=new ArrayDeque<>();
        Deque<String> stackstring=new ArrayDeque<>();
        int n=s.length();
        char[] ss=s.toCharArray();
        //放入空串以处理边界情况
        stackstring.push("");
        int sum=0;
        for(int i=0;i<n;i++){
            if(ss[i]>='0'&&ss[i]<='9') sum=sum*10+((int)(ss[i]-'0'));
                //修改：数字可能多位数
            else if(ss[i]=='[') {
                stackint.push(sum);sum=0;//修改：遇到[把数字放进去，同时重置sum
                stackstring.push("");
                //修改：再压一个空串给内层的字符串拼接用，否则外层跟内层连一起就混了
            }
            else if(ss[i]==']'&&!stackint.isEmpty()&&!stackstring.isEmpty()){
                //修改：防止两个栈空
                String ch=stackstring.pop();
                //解析（修改：用tmp记录原始值，循环拼接）
                String tmp=ch;
                int repeat=stackint.pop()-1;//提前存好，否则会多次弹出导致栈空
                for(int j=0;j<repeat;j++){
                    ch+=tmp;
                }
                stackstring.push(stackstring.pop()+ch);//修改：放入栈时记得拼接好前缀字符串
            }
            else stackstring.push(stackstring.pop()+String.valueOf(ss[i]));
        }
        return stackstring.isEmpty()?"":stackstring.pop();//修改：避免边界空栈
    }
    public String decodeString(String s) {
        //这次按照吴小哲的思路写
        Stack<StringBuffer> stack=new Stack<>();
        Stack<Integer> nums=new Stack<>();
        int n=s.length();char[] ss=s.toCharArray();
        stack.push(new StringBuffer());//先放个空串
        for(int i=0;i<n;){
            if(ss[i]>='0'&&ss[i]<='9'){
                int tmp=0;
                while(i<n&&ss[i]>='0'&&ss[i]<='9'){
                    tmp=tmp*10+(ss[i]-'0');i++;
                }
                nums.push(tmp);
            }else if(ss[i]=='['){
                i++;//i++放前面
                StringBuffer tmp=new StringBuffer();
                while(i<n&&ss[i]>='a'&&ss[i]<='z'){
                    tmp.append(ss[i]);//ss[i]本身就是字符，不用Sting.valueOf转换成字符串了
                    i++;
                }
                stack.push(tmp);
            }else if(ss[i]==']'){
                int k=nums.pop();
                StringBuffer tmp=stack.pop();
                while(k--!=0){//!=0
                    stack.push(stack.pop().append(tmp));
                    //stack.peek().append(tmp);也行
                }
                i++;//别忘了i++
            }else{
                StringBuffer tmp=new StringBuffer();
                while(i<n&&ss[i]>='a'&&ss[i]<='z'){
                    tmp.append(ss[i]);//ss[i]本身就是字符，不用Sting.valueOf转换成字符串了
                    i++;
                }
                stack.push(stack.pop().append(tmp));
                //stack.peek().append(tmp);也行
            }
        }
        return stack.pop().toString();//stack.peek().toString();也行
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }
}