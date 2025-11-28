/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-25
 * Time: 00:06
 */
class Solution {
    //自己按着解法二写的，一遍通过
    List<List<Integer>> ret;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        dfs(nums,0);
        return ret;
    }
    public void dfs(int[] nums,int pos){
        ret.add(new ArrayList<>(path));
        for(int i=pos;i<nums.length;i++){
            path.add(nums[pos++]);
            dfs(nums,pos);
            //回溯
            path.remove(path.size()-1);
        }
        return ;
    }
    //看吴小哲敲完后写的，注释处是自己写的解法一，但失败了
    List<List<Integer>> ret;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        dfs(nums,0);
        return ret;
    }
    public void dfs(int[] nums,int pos){
        if(pos==nums.length){ ret.add(new ArrayList<>(path));return;}
        //选
        path.add(nums[pos]);
        dfs(nums,pos+1);
        path.remove(path.size()-1);//回溯－>恢复原状
        //不选
        dfs(nums,pos+1);
    }
    //public void dfs(int[] nums,int i){
    //    if(i==nums.length) {ret.add(new ArrayList<>(path));path.add(i);}
    //    for(;i<nums.length;i++) dfs(nums,i);
    //    return;
    //};
}