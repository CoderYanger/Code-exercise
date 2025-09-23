import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-06
 * Time: 07:58
 */
class Solution {
    public int romanToInt2(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                sum += 4;
                i++;
            } else if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                sum += 9;
                i++;
            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                sum += 40;
                i++;
            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                sum += 90;
                i++;
            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                sum += 400;
                i++;
            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                sum += 900;
                i++;
            } else {
                switch (ch) {
                    case 'I': {
                        sum += 1;
                        break;
                    }
                    case 'V': {
                        sum += 5;
                        break;
                    }
                    case 'X': {
                        sum += 10;
                        break;
                    }
                    case 'L': {
                        sum += 50;
                        break;
                    }
                    case 'C': {
                        sum += 100;
                        break;
                    }
                    case 'D': {
                        sum += 500;
                        break;
                    }
                    case 'M': {
                        sum += 1000;
                        break;
                    }
                }
            }
        }

        return sum;
    }
    //用哈希表写
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        //放进键值对
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=0;
        //键放值出
        for(int i=0;i<s.length()-1;i++){
            int prev=map.get(s.charAt(i));
            int next=map.get(s.charAt(i+1));
            sum+=(prev>=next)?prev:-prev;
        }
        //加上最后一个字符的值
        sum+=map.get(s.charAt(s.length()-1));
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
    }
}

