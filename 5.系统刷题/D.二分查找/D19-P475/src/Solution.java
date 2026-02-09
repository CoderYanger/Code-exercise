import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-04
 * Time: 13:37
 */
class Solution {
    //475. 供暖器
    //解法一：二分查找+check暴力枚举（会超时）
    int m,n;
    public int findRadius(int[] houses, int[] heaters) {
        n=houses.length;m=heaters.length;
        //找到最远的位置作为right的初始值
        int left=0,right=0;
        for(int x:houses) right=Math.max(right,x);
        for(int x:heaters) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,houses,heaters)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断半径为mid时能否覆盖所有房屋
    private boolean check(int mid,int[] houses, int[] heaters){
        boolean[] mark=new boolean[n];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(Math.abs(houses[i]-heaters[j])<=mid) mark[i]=true;
        //看是否还有屋子没有被覆盖到
        //如果有就说明mid小了，返回true继续扩大mid尝试
        for(boolean x:mark) if(x==false) return true;
        return false;
    }

    //解法二：二分查找+check二分查找优化
    int m,n;
    public int findRadius(int[] houses, int[] heaters) {
        n=houses.length;m=heaters.length;
        //找到最远的位置作为right的初始值
        int left=0,right=0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        right=Math.max(houses[n-1],heaters[m-1]);
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,houses,heaters)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断半径为mid时能否覆盖所有房屋
    private boolean check(int mid,int[] houses, int[] heaters){
        for(int x:houses){
            //利用Java自带的二分查找找到第一个≥当前房屋的加热器位置
            int idx= Arrays.binarySearch(heaters,x);
            //转换为插入点
            if(idx<0) idx=-idx-1;
            boolean mark=false;
            //检查当前房屋与紧右侧加热器距离
            if(idx<m) mark=(heaters[idx]-x)<=mid;
            //检查当前房屋与紧左侧加热器距离
            if(idx-1>=0) mark=mark||(x-heaters[idx-1])<=mid;
            //只要有一个房屋没被覆盖，说明半径不够，直接返回true，继续扩大mid尝试
            if(!mark) return true;
        }
        return false;
    }


    //解法三：双指针
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ret=0;
        for(int i=0,j=0;i<houses.length;i++){
            //计算当前房屋与指针j指向供暖器的距离
            int cur=Math.abs(houses[i]-heaters[j]);
            //如果j+1位置的供暖器比j位置更近，就移动
            while(j<heaters.length-1&&Math.abs(houses[i]-heaters[j])>=Math.abs(houses[i]-heaters[j+1])){
                j++;
                cur=Math.min(cur,Math.abs(houses[i]-heaters[j]));
            }
            //更新全局最大半径
            ret=Math.max(ret,cur);
        }
        return ret;
    }
}
