/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:20
 */
class Solution {
    //1281. 整数的各位积和之差
    //0ms击败100.00%
    public int subtractProductAndSum(int n) {
        String s=String.valueOf(n);
        int sum=0,mul=1;
        for(char c:s.toCharArray()){
            sum+=c-'0';
            mul*=c-'0';
        }
        return mul-sum;
    }
}
