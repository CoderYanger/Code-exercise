/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 10:28
 */
class Solution {
    //3765. 完全质数
    public boolean completePrime(int num) {
        if(num==1) return false;
        String nums=String.valueOf(num);
        int n=nums.length();
        if(n==1) return islegal(num);
        //统计前缀
        for(int i=1;i<=n;i++)
            if(!islegal(Integer.valueOf(nums.substring(0,i))))
                return false;
        //统计后缀
        for(int i=0;i<n;i++)
            if(!islegal(Integer.valueOf(nums.substring(i,n))))
                return false;
        return true;
    }
    private boolean islegal(int x){
        if(x==1) return false;
        for(int i=2;i<x;i++)
            if(x%i==0) return false;
        return true;
    }
}
