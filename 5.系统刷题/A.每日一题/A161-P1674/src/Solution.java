/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-13
 * Time: 13:34
 */
class Solution {
    //1674. 使数组互补的最少操作次数
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] diff=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int x=nums[i];
            int y=nums[n-1-i];
            int l=Math.min(x,y)+1;
            int r=Math.max(x,y)+limit;
            //[2,l-1]+=2
            diff[2]+=2;
            diff[l]-=2;
            //[l,r]+=1;
            diff[l]++;
            diff[r+1]--;
            //x+y实际操作0次，从[l,r]中去掉
            diff[x+y]--;
            diff[x+y+1]++;
            //[r+1,limit*2]+=2
            diff[r+1]+=2;
            //limit*2+1不在[2,limit*2]中，可省略
        }
        int ret=0x3f3f3f3f;
        int sum=0;
        for(int i=2;i<=limit*2;i++){
            sum+=diff[i];
            ret=Math.min(ret,sum);
        }
        return ret;
    }

    //优化
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] diff=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int x=nums[i];
            int y=nums[n-1-i];
            int l=Math.min(x,y)+1;
            int r=Math.max(x,y)+limit;
            diff[l]--;
            diff[x+y]--;
            diff[x+y+1]++;
            diff[r+1]++;
        }
        int ret=0x3f3f3f3f;
        int sum=n;
        for(int i=2;i<=limit*2;i++){
            sum+=diff[i];
            ret=Math.min(ret,sum);
        }
        return ret;
    }
}
