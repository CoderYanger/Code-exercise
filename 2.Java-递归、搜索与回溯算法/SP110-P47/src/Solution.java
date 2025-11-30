/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-25
 * Time: 20:11
 */
class Solution {
    //47.全排列II
    //自己写的，一遍通过
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    Set<List<Integer>> set;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        check=new boolean[nums.length];
        set=new HashSet<>();
        dfs(nums);
        return ret;
    }
    public void dfs(int[] nums){
        if(path.size()==nums.length){
            if(!set.contains(path)){
                set.add(new ArrayList<>(path));
                ret.add(new ArrayList<>(path));
            }
            return;
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
        return;
    }
}