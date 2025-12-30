import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 12:46
 */
public class Solution {
    //3745. 三元素表达式的最大值
    public int maximizeExpressionOfThree(int[] nums) {
        //贪心：a+b最大，c最小
        int a=0,b=0,c=0;
        int n=nums.length;
        Integer[] tmp=new Integer[n];
        for(int i=0;i<n;i++) tmp[i]=nums[i];
        Arrays.sort(tmp);
        c=tmp[0];
        Arrays.sort(tmp,(n1,n2)->n2-n1);
        a=tmp[0];b=tmp[1];
        return a+b-c;
    }
}
