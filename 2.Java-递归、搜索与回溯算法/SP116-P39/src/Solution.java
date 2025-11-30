import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-03
 * Time: 20:15
 */
class Solution {
    //自己写的，注释处是找豆包改的
    List<Integer> path;
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path=new ArrayList<>();
        ret=new ArrayList<>();
        dfs(candidates,target,0);
        return ret;
    }
    public void dfs(int[] candidates, int target,int pos){
        if(pos==candidates.length) return;
        int sum=0;
        for(int x:path){
            sum+=x;
        }
        if(sum>target) return;
        if(sum==target){
            ret.add(new ArrayList<>(path));
            return;
        }
        //选择当前元素
        path.add(candidates[pos]);
        dfs(candidates,target,pos);
        path.remove(path.size()-1);//恢复现场,remove里应该是索引的位置，而不是具体元素
        //不选择当前元素，直接去下一个
        dfs(candidates,target,pos+1);
    }
    //吴小哲的解法一思路
    int aim;
    List<Integer> path;
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        aim=target;
        path=new ArrayList<>();
        ret=new ArrayList<>();
        dfs(candidates,0,0);
        return ret;
    }
    public void dfs(int[] candidates, int pos,int sum){
        if(sum>aim||pos==candidates.length) return;
        if(sum==aim){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,i,sum+candidates[i]);//这里不是+=，就是+
            path.remove(path.size()-1);//恢复现场
        }
    }
    //吴小哲的解法二思路
    int aim;
    List<Integer> path;
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        aim=target;
        path=new ArrayList<>();
        ret=new ArrayList<>();
        dfs(candidates,0,0);
        return ret;
    }
    public void dfs(int[] candidates, int pos,int sum){
        //if(sum>aim||pos==candidates.length) return;//放在这里就是错的
        //因为如果在索引越界的同时满足了sum==aim就会直接跳过返回，而不会添加到ret中
        if(sum==aim){
            ret.add(new ArrayList<>(path));
            return;
        }
        if(sum>aim||pos==candidates.length) return;
        //枚举nums[pos]使用多少个
        for(int k=0;k*candidates[pos]+sum<=aim;k++){
            if(k!=0) path.add(candidates[pos]);
            dfs(candidates,pos+1,sum+k*candidates[pos]);
        }
        //恢复现场：将这一阶段试过的所有可能出现次数的数全部删掉
        for(int k=1;k*candidates[pos]+sum<=aim;k++) path.remove(path.size()-1);
    }
}