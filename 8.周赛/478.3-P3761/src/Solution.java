import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-30
 * Time: 12:48
 */
class Solution {
    //3761. 镜像对之间最小绝对距离
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int ret=0x3f3f3f3f;
        //存<数,最后一次出现下标>
        //哈希表：记录更早的信息
        Map<Integer,Integer> hash=new HashMap<>();
        for(int j=0;j<n;j++){
            int cur=nums[j];
            //直接用当前数当key,检查之前是否有翻转数==key
            //如果把cur存进哈希表，然后查找cur的翻转值就会变成：
            //nums[i]==reverse(nums[j])
            //与题目要求的reverse(nums[i]) == nums[j]相反
            //就是i<j要成立，所以记录更早信息，要存cur的翻转值
            if(hash.containsKey(cur))
                ret=Math.min(ret,j-hash.get(cur));
            hash.put(reverse(cur),j);
        }
        return ret==0x3f3f3f3f?-1:ret;
    }
    private int reverse(int n){
        int ret=0;
        //自动去除了前导0
        while(n!=0){
            int t=n%10;
            ret=ret*10+t;
            n/=10;
        }
        return ret;
    }
}