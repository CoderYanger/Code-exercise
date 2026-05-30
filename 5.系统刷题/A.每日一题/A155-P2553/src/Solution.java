import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-11
 * Time: 13:07
 */
class Solution {
    //2553. 分割数组中数字的数位
    //解法一：字符串转化
    public int[] separateDigits(int[] nums) {
        List<Integer> t=new ArrayList<>();
        for(int x:nums){
            String s=String.valueOf(x);
            for(char c:s.toCharArray()) t.add(c-'0');
        }
        int[] ret=new int[t.size()];
        for(int i=0;i<t.size();i++) ret[i]=t.get(i);
        return ret;
    }

    //解法二：非字符串转化
    //写法一：直接存反转后的下标
    public int[] separateDigits(int[] nums) {
        List<Integer> t=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            while(nums[i]!=0){
                int a=nums[i]%10;
                t.add(a);
                nums[i]/=10;
            }
        }
        int[] ret=new int[t.size()];
        for(int i=0;i<t.size();i++) ret[i]=t.get(t.size()-1-i);
        return ret;
    }

    //解法二：非字符串转化
    //写法二：借用工具反转：Collections.reverse(t);
    public int[] separateDigits(int[] nums) {
        List<Integer> t=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            while(nums[i]!=0){
                int a=nums[i]%10;
                t.add(a);
                nums[i]/=10;
            }
        }
        int[] ret=new int[t.size()];
        Collections.reverse(t);
        for(int i=0;i<t.size();i++) ret[i]=t.get(i);
        return ret;
    }

    //解法二：非字符串转化
    //写法三：中间创建新的临时顺序表再反转填入
    public int[] separateDigits(int[] nums) {
        List<Integer> t=new ArrayList<>();
        for(int x:nums){
            List<Integer> l=new ArrayList<>();
            while(x!=0){
                int a=x%10;
                l.add(a);
                x/=10;
            }
            for(int i=l.size()-1;i>=0;i--) t.add(l.get(i));
        }
        int[] ret=new int[t.size()];
        for(int i=0;i<t.size();i++) ret[i]=t.get(i);
        return ret;
    }
}
