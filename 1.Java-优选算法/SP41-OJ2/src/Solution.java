/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-03
 * Time: 18:06
 */
class Solution {
    public int[] missingTwo1(int[] nums) {
        //自己按照思路写的，部分冗杂
        int n=nums.length;
        int ret=0;
        //先搞一个不缺的数组
        int[] num=new int[n+2];
        for(int i=1;i<=num.length;i++) num[i-1]=i;
        //先找到缺失的两个数的异或
        for(int i=0;i<n+2;i++) ret^=num[i];
        for(int x:nums) ret^=x;
        //找到最右侧的1来区分这两个数
        int h=1;
        int a=0,b=0;
        while((ret&h)==0) h<<=1;
        for(int i=0;i<n;i++){
            //注意分类的时候要用0来分，因为按位与&后的结果也可以不是1是其他的
            if((nums[i]&h)==0) a^=nums[i];
            else b^=nums[i];
        }
        //用本来不缺的数来消消乐
        for(int i=0;i<n+2;i++){
            if((num[i]&h)==0) a^=num[i];
            else b^=num[i];
        }
        return new int[]{a,b};
    }
    public int[] missingTwo(int[] nums) {
        //自己写的简化版本，速度有提升
        int n=nums.length,ret=0;
        //先用ret异或掉缺的和完整的，找到缺的俩数的异或
        for(int x:nums) ret^=x;
        for(int i=1;i<=n+2;i++) ret^=i;
        //找到比特位最右边的1
        int h=1;
        while((ret&h)==0) h<<=1;
        //根据刚刚的1来分为a,b组
        int a=0,b=0;
        for(int i=1;i<=n+2;i++){
            if((i&h)==0) a^=i;
            else b^=i;
        }
        for(int x:nums){
            if((x&h)==0) a^=x;
            else b^=x;
        }
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        int[] nums={2};
        int[] ret=new Solution().missingTwo(nums);
        for(int i=0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }
}
