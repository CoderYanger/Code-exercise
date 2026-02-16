/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 10:13
 */
class Solution {
    //1262. 可被三整除的最大和
    //动态规划解法(每日一题)
    public int maxSumDivThree(int[] nums) {
        int[] f={0,-0x3f3f3f3f,-0x3f3f3f3f};
        for(int x:nums){
            int[] g=new int[3];
            //将f数组从0位置开始复制到g数组从0开始，复制元素个数为3
            System.arraycopy(f,0,g,0,3);
            for(int i=0;i<3;i++)
                g[(i+x%3)%3]=Math.max(g[(i+x%3)%3],f[i]+x);
            f=g;
        }
        return f[0];
    }
}
