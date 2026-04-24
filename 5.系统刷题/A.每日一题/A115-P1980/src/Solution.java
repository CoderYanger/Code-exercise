import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 10:25
 */
class Solution {
    //1980. 找出不同的二进制字符串
    //解法一：暴力枚举-写法一：显式递归
    int n;
    private StringBuffer cur=new StringBuffer();
    public String findDifferentBinaryString(String[] nums) {
        n=nums.length;
        Set<String> hash=new HashSet<>();
        for(String s:nums) hash.add(s);
        return dfs(0,cur,hash);
    }
    private String dfs(int i,StringBuffer cur,Set<String> hash){
        if(i==n) return hash.contains(cur.toString())?"":cur.toString();

        cur.append("0");
        String s0=dfs(i+1,cur,hash);
        if(s0!="") return s0;
        cur.deleteCharAt(cur.length()-1);//回溯

        cur.append("1");
        String s1=dfs(i+1,cur,hash);
        if(s1!="") return s1;
        cur.deleteCharAt(cur.length()-1);//回溯

        //照顾编译器，因为题目保证有解
        return "";
    }

    //解法一：暴力枚举-写法二：隐式回溯
    int n;
    char[] cur;
    public String findDifferentBinaryString(String[] nums) {
        n=nums.length;
        cur=new char[n];
        Set<String> hash=new HashSet<>();
        for(String s:nums) hash.add(s);
        return dfs(0,cur,hash);
    }
    private String dfs(int i,char[] cur,Set<String> hash){
        if(i==n) return hash.contains(new String(cur))?"":new String(cur);

        cur[i]='0';
        String s0=dfs(i+1,cur,hash);
        if(s0!="") return s0;

        cur[i]='1';
        String s1=dfs(i+1,cur,hash);
        if(s1!="") return s1;

        //照顾编译器，因为题目保证有解
        return "";
    }

    //解法一：暴力枚举-写法三：枚举二进制对应的整数
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<Integer> hash=new HashSet<>();
        //转成整型存进哈希表
        for(String s:nums) hash.add(Integer.parseInt(s,2));
        for(int i=0;i<(1<<n);i++){
            if(!hash.contains(i)){
                String bin=Integer.toBinaryString(i);
                //手动添加前置0
                while(bin.length()<n) bin="0"+bin;
                return bin;
            }
        }

        //照顾编译器，因为题目保证有解
        return "";
    }


    //解法一：暴力枚举-写法三：枚举二进制对应的整数(优化版)
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> hash=new HashSet<>();
        //转成整型存进哈希表
        for(String s:nums) hash.add(Integer.parseInt(s,2));
        int ret=0;
        while(hash.contains(ret)) ret++;
        String bin=Integer.toBinaryString(ret);
        return "0".repeat(nums.length-bin.length())+bin;
    }


    //解法二：康托对角线
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] ret = new char[n];
        for (int i = 0; i < n; i++) ret[i] = (char) (nums[i].charAt(i) ^ 1);
        return new String(ret);
    }
}
