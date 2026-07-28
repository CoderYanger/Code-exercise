import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-26
 * Time: 15:56
 */
class Solution {
    //1833. 雪糕的最大数量
    //解法一：贪心+排序
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0;
        for(int x:costs){
            coins-=x;
            if(coins>=0) cnt++;
            else break;
        }
        return cnt;
    }

    //解法二：贪心+计数排序
    public int maxIceCream(int[] costs, int coins) {
        int mx=0;
        for(int x:costs) mx=Math.max(mx,x);
        //统计计数数组
        int[] cnt=new int[mx+1];
        for(int x:costs) cnt[x]++;
        //按照价格从低到高购买
        int ret=0;
        //从低费往高费遍历，且费用要<兜里的钱
        for(int price=1;price<=mx&&price<=coins;price++){
            //能买的个数=min(库存，能购买的最大数目)
            int num=Math.min(cnt[price],coins/price);
            //买 num 根雪糕
            coins-=price*num;
            ret+=num;
        }
        return ret;
    }
    
}
