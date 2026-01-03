/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-14
 * Time: 17:57
 */
class Solution {
    //LCR 018. 验证回文串
    //从125题搬来的
    //第一次忽略了大小写和for-each不能直接遍历字符串
    //第二次忽略了还有数字，不单单是字母
    public boolean isPalindrome(String s) {
        //先把字母提取出来
        StringBuffer sb=new StringBuffer();
        //字符串不能直接for-each遍历，需要先toCharArray()转换成数组
        for(char c:s.toCharArray())
            if((c>='a')&&(c<='z')||(c>='A')&&(c<='Z')||(c>='0'&&c<='9'))
                sb.append(Character.toUpperCase(c));
        char[] str=sb.toString().toCharArray();
        if(str.length==0) return true;
        int left=0,right=str.length-1;
        while(left<right){
            if(str[left]==str[right]){left++;right--;}
            else return false;
        }
        return true;
    }
}