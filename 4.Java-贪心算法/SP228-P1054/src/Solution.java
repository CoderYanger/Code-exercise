import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-13
 * Time: 12:25
 */
class Solution {
    //1054.距离相等的条形码
    public int[] rearrangeBarcodes(int[] nums) {
        //自己写的时候其余的随便填的代码没弄出来，就卡在这儿了
        //最后还是看的吴小哲的

        //int n=nums.length;
        //int[] ret=new int[n];
        //int[] hash=new int[10001];
        //for(int i=0;i<n;i++) hash[nums[i]]++;
        //int max=0;//记录出现次数最多的数字的次数
        //int tmp=0;//记录出现次数最多的数字
        //for(int i=0;i<10001;i++)
        //    if(hash[i]>max){
        //        max=hash[i];
        //        tmp=i;
        //    }
        //for(int i=0;max!=0;i+=2){
        //    ret[i]=tmp;
        //    max--;
        //}
        ////其余的随便填了
        //int j=1;
        //for(int i=0;i<10001;i++){
        //    if(i==tmp) continue;
        //    if(hash[i]!=0&&ret[j]==0) ret[j++]=i;
        //}
        //return ret;

        Map<Integer,Integer> hash=new HashMap<>();
        int n=nums.length,maxval=0,maxcount=0;
        int[] ret=new int[n];
        //放进哈希表，同时统计出现次数最多的数及其次数
        for(int x:nums){
            hash.put(x,hash.getOrDefault(x,0)+1);
            if(hash.get(x)>maxcount){
                maxval=x;
                maxcount=hash.get(x);
            }
        }
        int index=0;
        //把次数最多的数填进去
        for(int i=0;i<maxcount;i++){
            ret[index]=maxval;
            index+=2;
        }
        //把出现次数最多的数从哈希表中删除，剩下的随便填
        hash.remove(maxval);//直接把Key删掉
        for(int x:hash.keySet()){
            //自己写的时候把这个落下了，要把这个键值所对应的次数全部用上
            for(int i=0;i<hash.get(x);i++){
                if(index>=n) index=1;
                ret[index]=x;
                index+=2;
            }
        }
        return ret;
    }
}