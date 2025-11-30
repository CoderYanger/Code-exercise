import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-25
 * Time: 21:25
 */
class Solution {
    //LCR.084.全排列Ⅱ
    //看完吴小哲讲完之后写的，比我写的简洁很多，主要体现在他在放入path前提前剪枝了，而我是全放进去之后用Set去重的
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        check=new boolean[nums.length];
        Arrays.sort(nums);//忘添加了
        dfs(nums);
        return ret;
    }
    public void dfs(int[] nums){
        if(path.size()==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //关心不合法的
            //剪枝
            if(check[i]==true||(i!=0&&nums[i]==nums[i-1]&&check[i-1]==false)) continue;
            //后面是check[i-1]而不是check[i]，意思是前一个还没用呢，现在这个又和前一个一样就不合法
            path.add(nums[i]);
            check[i]=true;
            dfs(nums);
            check[i]=false;
            path.remove(path.size()-1);
        }
    }
    public void dfs(int[] nums){
        if(path.size()==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //关心合法的（直接全反着写,去掉continue）
            //剪枝
            if(check[i]!=true&&(i==0||nums[i]!=nums[i-1]||check[i-1]!=false)){
                path.add(nums[i]);
                check[i]=true;
                dfs(nums);
                check[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}