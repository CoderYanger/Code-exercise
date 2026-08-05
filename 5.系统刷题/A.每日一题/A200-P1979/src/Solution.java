/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-26
 * Time: 15:39
 */
class Solution {
    //1979. 找出数组的最大公约数
    public int findGCD(int[] nums) {
        int min=1000,max=1;
        for(int x:nums){
            if(x>max) max=x;
            if(x<min) min=x;
        }
        return gcd(max,min);
    }
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}