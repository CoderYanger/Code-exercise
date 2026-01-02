/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-23
 * Time: 12:05
 */
class Solution {
    //3751. 范围内总波动值 I
    public int totalWaviness(int num1, int num2) {
        int ret=0;
        for(int i=num1;i<=num2;i++)
            ret+=islegal(i);
        return ret;
    }
    public int islegal(int n){
        String s=String.valueOf(n);
        if(s.length()<3) return 0;
        //将数字的每一位转为整数数组，方便比较
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++)
            nums[i]=s.charAt(i)-'0';
        int ret=0;
        //遍历中间数位
        for(int i=1;i<s.length()-1;i++){
            int cur=nums[i],left=nums[i-1],right=nums[i+1];
            //判断是否为峰值
            if(cur>left&&cur>right) ret++;
                //判断是否为谷值
            else if(cur<left&&cur<right) ret++;
        }
        return ret;
    }
}