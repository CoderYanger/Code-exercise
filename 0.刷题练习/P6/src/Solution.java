/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-04
 * Time: 14:37
 */
class Solution {

    //6. Z 字形变换
    /*将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    P   A   H   N
    A P L S I I G
    Y   I   R
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    请你实现这个将字符串进行指定行数变换的函数：
    string convert(string s, int numRows);
    示例 1：
    输入：s = "PAYPALISHIRING", numRows = 3
    输出："PAHNAPLSIIGYIR"
    示例 2：
    输入：s = "PAYPALISHIRING", numRows = 4
    输出："PINALSIGYAHRPI"
    解释：
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    示例 3：
    输入：s = "A", numRows = 1
    输出："A"
    提示：
            1 <= s.length <= 1000
    s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000*/

    //自己写的：
    public String convert1(String s, int numRows) {
        char[][]arr=new char[numRows][s.length()/4+1];
        int j=0;//控制列
        int i=0;//控制行
        for(int k=0;k<s.length();k++){//从头遍历字符串
            while(i<numRows){
                arr[i][j]=s.charAt(k);
                i++;
                k++;
            }
            while(j<numRows-1&&i-1>=0){
                j++;
                arr[i-1][j]=s.charAt(k);
                k++;
            }
        }
        char[]str=new char[s.length()];
        int b=0;
        for(int m=0;m<numRows;m++){
            for(int n=0;n<s.length()/4+1;n++){
                if(arr[m][n]!=0){
                    str[b++]=arr[m][n];
                    System.out.print(arr[m][n]);
                }
            }
        }
        String ss=new String(str);
        return ss;
    }
    //豆包照着我的思路改的：
        public static String convert(String s, int numRows) {
            if(s.length()<=1||numRows<=1)return s;
            int k=0;
            int i=0,j=0;
            char[][]arr=new char[numRows][s.length()];
            while(k<s.length()){
                while(i<numRows&&k<s.length()){
                    arr[i][j]=s.charAt(k);
                    i++;
                    k++;
                }
                if(k>=s.length())break;
                i-=2;
                j++;
                while(i>0&&k<s.length()){
                    arr[i][j]=s.charAt(k);
                    i--;
                    j++;
                    k++;
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int m=0;m<numRows;m++){
                for(int n=0;n<s.length();n++){
                    if(arr[m][n]!=0){
                        sb.append(arr[m][n]);
                    }
                }
            }
            return sb.toString();
        }
        public static void main(String[] args) {
            String s="PAYPALISHIRING";
            int numRows=3;
            System.out.println(convert(s,numRows));
        }
    }
