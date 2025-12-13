/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-10
 * Time: 19:03
 */
class Solution {
    //134. 加油站
    //自己写的暴力解法，但在步数和下标的映射关系上有点偏差，找AI稍作修改，但仍会超时
    //吴小哲也是这么写的
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n=gas.length;
        int[] diff=new int[n];
        for(int i=0;i<n;i++) diff[i]=gas[i]-cost[i];
        for(int i=0;i<n;i++){
            if(diff[i]<0) continue;
            int sum=diff[i];
            for(int step=1;step<n;step++){
                int index=(i+step)%n;
                sum+=diff[index];
                if(sum<0) break;//油量不够，提前退出
            }
            if(sum>=0) return i;//一圈下来，油量还有，就返回
        }
        return -1;
    }

    //在暴力解法上加一句优化即可
    //测试用例一直报错，一提交就通过了
    //因为这个报错我卡了半天，没想到成小丑了，力扣真有意思
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int[] diff=new int[n];
        for(int i=0;i<n;i++) diff[i]=gas[i]-cost[i];
        for(int i=0;i<n;i++){//枚举所有的起点
            if(diff[i]<0) continue;
            int sum=diff[i];
            int step=1;//sum已经算第一个了，所以这里从第二个位置开始计入
            for(;step<n;step++){
                int index=(i+step)%n;
                sum+=diff[index];
                if(sum<0) break;//油量不够，提前退出
            }
            if(sum>=0) return i;//一圈下来，油量还有，就返回
            //优化
            i=i+step;//因为循环有i++了，所以这里不用+1了
        }
        return -1;
    }
}