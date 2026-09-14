import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-15
 * Time: 10:13
 */
class Solution {
    //101005. 数对的最大公约数之和
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long[] prefixGcd=new long[n];
        long mxi=0;
        for(int i=0;i<n;i++){
            mxi=Math.max(mxi,nums[i]);
            prefixGcd[i]=gcd(nums[i],mxi);
        }
        Arrays.sort(prefixGcd);
        long ret=0;
        int left=0,right=n-1;
        while(left<right){
            ret+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return ret;
    }
    //获取最大公约数
    private long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }

    //优化
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd=new int[n];
        int mxi=0;
        for(int i=0;i<n;i++){
            mxi=Math.max(mxi,nums[i]);
            prefixGcd[i]=gcd(nums[i],mxi);
        }
        Arrays.sort(prefixGcd);
        long ret=0;
        int left=0,right=n-1;
        while(left<right){
            ret+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return ret;
    }
    //获取最大公约数
    private int gcd(int a,int b){
        while(a!=0){
            int tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }

}
