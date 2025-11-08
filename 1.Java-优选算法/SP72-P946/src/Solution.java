import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-16
 * Time: 22:35
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //自己写的，改改就过了
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}