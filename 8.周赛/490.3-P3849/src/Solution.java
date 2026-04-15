/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-22
 * Time: 16:03
 */
class Solution {
    //3849. 重新排列后的最大按位异或值
    //解法一：模拟+StringBuffer()
    public String maximumXor(String s, String t) {
        int[] hash=new int[2];
        for(int x:t.toCharArray()) hash[x-'0']++;
        StringBuffer sb=new StringBuffer();
        for(int x:s.toCharArray()){
            if(x=='1'){
                if(hash[0]>0){
                    sb.append(1);
                    hash[0]--;
                }
                else sb.append(0);
            }else{
                if(hash[1]>0){
                    sb.append(1);
                    hash[1]--;
                }
                else sb.append(0);
            }
        }
        return sb.toString();
    }

    //解法二：模拟+数组代替StringBuffer()
    public String maximumXor(String s, String t) {
        //统计t中字符1的个数，剩下的就是0的个数
        int cnt=0;
        for(char c:t.toCharArray()) cnt+=c-'0';
        int[] hash=new int[]{t.length()-cnt,cnt};
        char[] ret=s.toCharArray();
        for(int i=0;i<ret.length;i++){
            int x=ret[i]-'0';
            //x==0时
            if(x==0){
                if(hash[1]>0){
                    hash[1]--;
                    ret[i]='1';
                }else{
                    hash[0]--;
                    ret[i]='0';
                }
            }else{
                if(hash[0]>0){
                    hash[0]--;
                    ret[i]='1';
                }else{
                    hash[1]--;
                    ret[i]='0';
                }
            }
        }
        return new String(ret);
    }

    //解法二优化：模拟+数组代替StringBuffer()
    public String maximumXor(String s, String t) {
        //统计t中字符1的个数，剩下的就是0的个数
        int cnt=0;
        for(char c:t.toCharArray()) cnt+=c-'0';
        int[] hash=new int[]{t.length()-cnt,cnt};
        char[] ret=s.toCharArray();
        for(int i=0;i<ret.length;i++){
            int x=ret[i]-'0';
            //优先让两个不同的数异或
            //hash[x^1]>0代表还能让不同的数进行异或
            if(hash[x^1]>0){
                hash[x^1]--;
                ret[i]='1';
            }else{//只能让两个相同的数异或
                hash[x]--;
                ret[i]='0';
            }
        }
        return new String(ret);
    }
}
