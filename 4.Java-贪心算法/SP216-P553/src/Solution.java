/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-06
 * Time: 19:01
 */
class Solution {
    //553.最优除法
    //自己写的，错在了忘记判断边界条件，n==1和n==2的情况
    //添加字符时只能单个添加，不能写成'/('
    public String optimalDivision(int[] nums) {
        int n=nums.length;
        StringBuffer sb=new StringBuffer();
        sb.append(nums[0]);
        if(n==1) return sb.toString();
        if(n==2){
            sb.append('/');
            sb.append(nums[1]);
            return sb.toString();
        }
        sb.append('/');
        sb.append('(');
        sb.append(nums[1]);
        for(int i=2;i<n;i++){
            sb.append('/');
            sb.append(nums[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    //吴小哲的解法
    //1.append可以连续追加
    //2.想一次性添加/(用“”
    public String optimalDivision2(int[] nums) {
        int n=nums.length;
        StringBuffer ret=new StringBuffer();
        //先处理两个边界情况
        if(n==1) return ret.append(nums[0]).toString();
        if(n==2) return ret.append(nums[0]).append("/").append(nums[1]).toString();
        ret.append(nums[0]).append("/(").append(nums[1]);
        for(int i=2;i<n;i++) ret.append("/").append(nums[i]);
        ret.append(")");
        return ret.toString();
    }
}