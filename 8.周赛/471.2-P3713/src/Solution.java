import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:55
 */
class Solution {
    //3713. 最长的平衡子串 I
    public int longestBalanced(String s) {
        int n=s.length();
        if(n==0) return 0;
        int maxlen=1;
        for(int i=0;i<n;i++){
            int[] nums=new int[26];
            for(int j=i;j<n;j++){
                int x=s.charAt(j)-'a';
                nums[x]++;
                List<Integer> counts=new ArrayList<>();
                for(int k=0;k<26;k++){
                    if(nums[k]>0) counts.add(nums[k]);
                }
                boolean isBalanced=true;
                int first=counts.get(0);
                for(int cnt:counts){
                    if(cnt!=first){
                        isBalanced=false;
                        break;
                    }
                }
                if(isBalanced){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
}