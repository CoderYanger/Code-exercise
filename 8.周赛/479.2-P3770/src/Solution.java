import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 14:30
 */
class Solution {
    //3770. 可表示为连续质数和的最大质数
    public int largestPrime(int n) {
        if(n==1) return 0;
        //核心优化：用埃氏筛标记质数，替代islegal和HashSet
        boolean[] isPrime=new boolean[n+1];
        for(int i=2;i<=n;i++) isPrime[i]=true;//先默认所有数都是质数
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                //如果i是质数，那么i的所有倍数都不是质数
                for(int j=i*i;j<=n;j+=i)
                    isPrime[j]=false;
            }
        }
        List<Integer> prime=new ArrayList<>();
        for(int i=2;i<=n;i++)
            if(isPrime[i])
                prime.add(i);
        int[] sum=new int[prime.size()];
        if(prime.isEmpty()) return 0;
        sum[0]=prime.get(0);
        if(sum[0]>n) return 0;
        for(int i=1;i<prime.size();i++){
            sum[i]=sum[i-1]+prime.get(i);
            if(sum[i]>n){
                //及时截断
                sum= Arrays.copyOf(sum,i);
                break;
            }
        }
        for(int i=sum.length-1;i>=0;i--)
            if(isPrime[sum[i]]) return sum[i];
        return 0;
    }
}