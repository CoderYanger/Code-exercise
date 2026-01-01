/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:57
 */
class Solution {
    //3722. 反转后字典序最小的字符串
    public String lexSmallest(String s) {
        int n=s.length();
        String minStr=s;
        //反转前k个
        for(int k=1;k<=n;k++){
            char[] arr=s.toCharArray();
            reverse(arr,0,k-1);
            String newStr=new String(arr);
            if(newStr.compareTo(minStr)<0)
                minStr=newStr;
        }
        //反转后k个
        for(int k=1;k<=n;k++){
            char[] arr=s.toCharArray();
            reverse(arr,n-k,n-1);
            String newStr=new String(arr);
            if(newStr.compareTo(minStr)<0)
                minStr=newStr;
        }
        return minStr;
    }
    public void reverse(char[] arr,int start,int end){
        while(start<end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}