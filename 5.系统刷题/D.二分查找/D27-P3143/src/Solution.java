import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-12
 * Time: 15:06
 */
class Solution {
    //解法一：二分查找-二分答案
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n=s.length();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int p=Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            map.computeIfAbsent(p,_->new ArrayList<>()).add(s.charAt(i)-'a');
        }
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(mid,map)) right=mid-1;
            else left=mid;
        }
        return left;
    }
    //判断加入当前点后的正方形是否合法
    private boolean check(int mid,Map<Integer,List<Integer>> map){
        List<Integer> pList=new ArrayList<>(map.keySet());
        Collections.sort(pList);//按p从小到大排序
        int cnt=0;
        Set<Integer> hash=new HashSet<>();
        int max_p=-1;
        //1.找到前mid个点对应的最大p值
        for(int p:pList){
            List<Integer> chars=map.get(p);
            for(int c:chars){
                if(cnt<mid){
                    if(hash.contains(c)) return false;
                    hash.add(c);
                    cnt++;
                    max_p=p;//更新最大p值
                }else break;
            }
            if(cnt>=mid) break;
        }
        //2.检查所有p≤max_p的点是否存在重复
        hash.clear();
        for(int p:pList){
            if(p>max_p) break;
            for(int c:map.get(p)){
                if(hash.contains(c)) return false;
                hash.add(c);
            }
        }
        return true;
    }

    //解法二：二分查找-二分间接值
    private int ret;
    public int maxPointsInsideSquare(int[][] points, String ss) {
        char[] s=ss.toCharArray();
        int left=-1,right=1_000_000_001;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(mid,points,s)) right=mid-1;
            else left=mid;
        }
        return ret;
    }
    private boolean check(int size,int[][]points,char[]s){
        //使用int类型vis记录标签出现情况
        int vis=0;
        for(int i=0;i<points.length;i++){
            //判断当前点是否在半长为size的正方形内
            //条件：x和y的绝对值≤size
            if(Math.abs(points[i][0])<=size&&Math.abs(points[i][1])<=size){
                int c=s[i]-'a';
                //取出vis的第c位，若为1，则表示已出现
                if((vis>>c&1)>0) return false;
                //将vis的第c位置为1
                vis|=1<<c;
            }
        }
        //所有在正方形内的点标签都不重复，更新答案为当前正方形内的点数
        //Integer.bitCount(vis):计算vis的二进制里有多少个1
        ret=Integer.bitCount(vis);
        return true;
    }
}
