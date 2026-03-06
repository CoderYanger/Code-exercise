import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-22
 * Time: 21:54
 */
class Solution {
    //3507. 移除最小数对使数组有序 I
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums) list.add(x);
        int count=0;
        while(list.size()>1){
            //默认满足非递减条件
            boolean islegal=true;
            //维护最小和
            int minsum=0x3f3f3f3f;
            //标记要修改的位置
            int index=0;
            for(int i=0;i<list.size()-1;i++){
                int sum=list.get(i)+list.get(i+1);
                //判断是否非递减
                if(list.get(i)>list.get(i+1)) islegal=false;
                //更新最小和
                if(sum<minsum){
                    minsum=sum;
                    index=i;
                }
            }
            if(islegal) break;
            //没有break，说明还是非递减的状态，需要移除最小和
            count++;
            list.set(index,minsum);
            list.remove(index+1);
        }
        return count;
    }
}