import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-21
 * Time: 16:54
 */
class Solution {
    //3780. 能被 3 整除的三元组最大和
    public int maximumSum(int[] nums) {
        int n=nums.length,ret=0;
        if(n<3) return 0;
        List<Integer> mod0=new ArrayList<>();
        List<Integer> mod1=new ArrayList<>();
        List<Integer> mod2=new ArrayList<>();
        for(int x:nums){
            if(x%3==0) mod0.add(x);
            else if(x%3==1) mod1.add(x);
            else mod2.add(x);
        }
        //对每个集合降序，方便取最大值
        Collections.sort(mod0,(a, b)->b-a);
        Collections.sort(mod1,(a,b)->b-a);
        Collections.sort(mod2,(a,b)->b-a);
        int size0=mod0.size(),size1=mod1.size(),size2=mod2.size();
        if(size0>=3) ret=Math.max(ret,mod0.get(0)+mod0.get(1)+mod0.get(2));
        if(size1>=3) ret=Math.max(ret,mod1.get(0)+mod1.get(1)+mod1.get(2));
        if(size2>=3) ret=Math.max(ret,mod2.get(0)+mod2.get(1)+mod2.get(2));
        if(size0>=1&&size1>=1&&size2>=1) ret=Math.max(ret,mod0.get(0)+mod1.get(0)+mod2.get(0));
        return ret;
    }
}