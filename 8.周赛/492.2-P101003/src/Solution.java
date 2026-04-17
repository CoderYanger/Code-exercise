/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 16:13
 */
class Solution {
    //101003. 找出最小平衡下标
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        //记录前缀和:prev[i]:i左侧所有元素的和
        long[] prev=new long[n];prev[0]=0;
        //记录后缀积:suff[i]:i右侧所有元素的积
        long[] suff=new long[n];suff[n-1]=1;
        for(int i=1;i<n;i++) prev[i]=prev[i-1]+nums[i-1];
        for(int i=n-2;i>=0;i--){
            if(suff[i+1]*nums[i+1]<Long.MAX_VALUE) suff[i]=suff[i+1]*nums[i+1];
            else{suff[i]=0;break;}
        }
        for(int i=0;i<n;i++){
            if(suff[i]==0) continue;
            if(prev[i]==suff[i]) return i;
        }
        return -1;
    }

    //优化版本
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long prev=0;
        for(int i=0;i<n-1;i++) prev+=nums[i];
        long suff=1;
        for(int i=n-1;i>0;i--){
            if(prev==suff) return i;
            prev-=nums[i-1];
            if(suff>prev/nums[i]) break;
            suff*=nums[i];
        }
        return -1;
    }
    
}
