/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-25
 * Time: 19:30
 */
class Solution {
    //1863. 子集异或和
    //自己按上题的解法二的思路写的
    List<List<Integer>> ret;
    List<Integer> path;
    public int subsetXORSum(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        dfs(nums,0);
        int sum=0;
        int[] num=new int[ret.size()];
        for(List<Integer> t:ret){
            //空集就一个，还是0，就跳了
            if(t.size()==1) sum+=t.get(0);
            if(t.size()>1){
                int tmp=0;
                for(int x:t){
                    tmp^=x;
                }
                sum+=tmp;
            }
        }
        return sum;
    }
    public void dfs(int[] nums,int pos){
        ret.add(new ArrayList<>(path));
        for(int i=pos;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1);//这里忽略了
            //回溯
            path.remove(path.size()-1);
        }
        return;
    }

    //自己按上题的解法一的思路写的，一遍过
    List<List<Integer>> ret;
    List<Integer> path;
    public int subsetXORSum(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        dfs(nums,0);
        int sum=0;
        int[] num=new int[ret.size()];
        for(List<Integer> t:ret){
            //空集就一个，还是0，就跳了
            if(t.size()==1) sum+=t.get(0);
            if(t.size()>1){
                int tmp=0;
                for(int x:t){
                    tmp^=x;
                }
                sum+=tmp;
            }
        }
        return sum;
    }
    public void dfs(int[] nums,int pos){
        if(pos==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        //选
        path.add(nums[pos]);
        dfs(nums,pos+1);
        path.remove(path.size()-1);
        //不选
        dfs(nums,pos+1);
    }

    //吴小哲的解法，就是解法二的方法，但是利用了整型和异或消消乐的特性，代码更简洁
    int sum;
    int path;
    public int subsetXORSum(int[] nums) {
        dfs(nums,0);
        return sum;
    }
    public void dfs(int[] nums,int pos){
        sum+=path;
        for(int i=pos;i<nums.length;i++){
            path^=nums[i];
            dfs(nums,i+1);
            //用消消乐来恢复现场
            path^=nums[i];
        }
    }
}
