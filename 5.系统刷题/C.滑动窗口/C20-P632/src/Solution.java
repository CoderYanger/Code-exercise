import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 18:59
 */
class Solution {
    //632. 最小区间
    public int[] smallestRange(List<List<Integer>> nums) {
        //①统计所有数字的总个数
        int allcount=0;
        for(List<Integer> group:nums) allcount+=group.size();
        //②构建二维数组hash，存储<数字，所属组号>
        int[][] hash=new int[allcount][2];
        int index=0;//用于遍历每组中的数字
        int id=0;//记录该数字的组号
        for(List<Integer> group:nums){
            for(int num:group){
                hash[index][0]=num;
                hash[index][1]=id;
                index++;//继续遍历下一个数字
            }
            id++;//切换到下一组
        }
        //③对hash二维数组按 数字值 升序排序
        Arrays.sort(hash,(a, b)->a[0]-b[0]);
        //④初始化滑动窗口相关变量
        int[] ret=new int[2];//最终结果
        //目标组数：总共的组数，需要当前窗口包含所有组数
        int target=nums.size();
        //统计当前窗口中每个组的数字个数
        //比如count[2]=3表示2组在窗口中有3个数字
        int[] count=new int[target];
        //统计当前窗口中不同组的数量，目标是达到target
        int window=0;
        int left=0;//窗口的左边界
        for(int right=0;right<allcount;right++){
            //当前遍历到的数字：hash[right][0],所属组号hash[right][1];
            int curid=hash[right][1];//获取当前数字所属组号
            //进窗口：给当前组计数+1，如果加之前计数是0，说明这个组是第一次进窗口
            if(count[curid]++==0) window++;
            //更新：如果当前窗口已经包含所有组，就开始出窗口（收缩左边界）
            if(window==target){
                //收缩时要保证去掉这个数字后，该数字所在组仍有其他数字在窗口内
                while(count[hash[left][1]]-1>0){
                    count[hash[left][1]]--;
                    left++;
                }
                //当前窗口区间[hash[left][0],hash[right][0]]
                //更新条件：
                //1.ret初始是[0,0]，第一次找到有效窗口，直接赋值
                //2.当前窗口长度更小
                if((ret[0]==0&&ret[1]==0)||(hash[right][0]-hash[left][0]<ret[1]-ret[0])){
                    ret[0]=hash[left][0];//更新左边界
                    ret[1]=hash[right][0];//更新右边界
                }
            }
        }
        //返回最终找到的最小区间
        return ret;
    }
}