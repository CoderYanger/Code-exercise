import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-10
 * Time: 17:09
 */
class Solution {
    //1390. 四因数
    public int sumFourDivisors(int[] nums) {
        int ret=0;
        //建立备忘录
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums){
            //先往备忘录里瞅瞅
            if(hash.containsKey(x)){
                ret+=hash.get(x);
                continue;
            }
            int count=0,sum=0;
            for(int i=2;i<=Math.pow(x,0.5);i++){
                if(x%i==0&&i!=x/i){
                    count+=2;
                    sum+=(i+x/i);
                }else if(x%i==0&&i==x/i){
                    count++;
                    sum+=i;
                }
                if(count>2) break;
            }
            if(count==2){
                hash.put(x,x+1+sum);
                ret+=(x+1+sum);
            }
        }
        return ret;
    }
}