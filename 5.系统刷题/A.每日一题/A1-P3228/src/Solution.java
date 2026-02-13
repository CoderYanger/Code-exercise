/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-14
 * Time: 10:55
 */
class Solution {
    //3228. 将 1 移动到末尾的最大操作次数
    //自己写的基本一遍过，但是时间复杂度有点大了，超时了，最后还是看了官方题解
    //关键就在于：每个1需要移动的次数=0的段数
    public int maxOperations(String s) {
        int ret=0,count=0;
        int i=0;
        int n=s.length();
        while(i<n){
            if(s.charAt(i)=='0'){
                //这里要判断i+1的位置,因为还判断i位置的话i就重复加了两遍了
                while(i+1<n&&s.charAt(i+1)=='0') i++;
                ret+=count;//每次遇到0都统计一遍前面1的个数
            }
            else count++;;
            i++;
        }
        return ret;
    }

    //自己第一次写的正确但超时的代码
    public int maxOperations1(String ss) {
        int ret=0;
        char[] s=ss.toCharArray();
        int n=s.length;
        //有1才能移动
        int sum=0;
        for(char c:s) if(c=='1') sum++;
        for(int k=0;k<sum;k++){
            for(int i=0;i+1<n;i++){
                if(s[i]=='1'&&s[i+1]=='0'){
                    ret++;//操作一次
                    while(i+1<n&&s[i+1]=='0'){
                        s[i]='0';s[i+1]='1';
                        i++;
                    }
                }
            }
        }
        return ret;
    }
}
