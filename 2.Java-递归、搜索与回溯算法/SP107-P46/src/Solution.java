/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-24
 * Time: 21:09
 */
class Solution {
    //自己又写了一遍
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        check=new boolean[nums.length];
        dfs(nums);
        return ret;
    }
    public void dfs(int[] nums){
        //递归出口：该路径达到了数目
        if(path.size()==nums.length){
            ret.add(new ArrayList<>(path));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(check[i]==false){
                path.add(nums[i]);
                check[i]=true;
                dfs(nums);
                //回溯->恢复现场
                check[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}