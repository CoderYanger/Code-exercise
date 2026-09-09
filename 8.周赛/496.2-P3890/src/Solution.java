import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-06
 * Time: 16:08
 */
class Solution {
    //3890. 可由多种立方和构造的整数
    public List<Integer> findGoodIntegers(int n) {
        long mx=0;
        while(true){
            long next=mx+1;
            if(next*next*next<=n) mx++;
            else break;
        }
        Map<Integer,Integer> hash=new HashMap<>();
        for(long a=1;a<=mx;a++){
            long a3=a*a*a;
            for(long b=a;b<=mx;b++){
                long b3=b*b*b;
                long sum=a3+b3;
                if(sum<=n) hash.merge((int)sum,1,Integer::sum);
            }
        }
        List<Integer> ret=new ArrayList<>();
        //统计个数
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(entry.getValue()>=2) ret.add(entry.getKey());
        }
        //升序排序
        Collections.sort(ret);
        return ret;
    }
}