import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-06
 * Time: 14:43
 */
class Solution {
    //1419.数青蛙
    /*给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
    由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
    请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
    要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，
    那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
    示例 1：
    输入：croakOfFrogs = "croakcroak"
    输出：1
    解释：一只青蛙 “呱呱” 两次
    示例 2：
    输入：croakOfFrogs = "crcoakroak"
    输出：2
    解释：最少需要两只青蛙，“呱呱” 声用黑体标注
    第一只青蛙 "crcoakroak"
    第二只青蛙 "crcoakroak"
    示例 3：
    输入：croakOfFrogs = "croakcrook"
    输出：-1
    解释：给出的字符串不是 "croak" 的有效组合。
    提示：
            1 <= croakOfFrogs.length <= 105
    字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'*/
    public int minNumberOfFrogs(String croakOfFrogs) {
        //自己根据吴小哲的思路写的代码
        int[] str=new int[5];//先创建对应数组
        for(int i=0;i<croakOfFrogs.length();i++){
            char ch=croakOfFrogs.charAt(i);
            switch(ch-'a'){
                case 2 :if(str[4]>0){str[4]--;str[0]++;}else str[0]++;break;
                case 17:if(str[0]>0){str[0]--;str[1]++;}else return -1;break;
                case 14:if(str[1]>0){str[1]--;str[2]++;}else return -1;break;
                case 0 :if(str[2]>0){str[2]--;str[3]++;}else return -1;break;
                case 10:if(str[3]>0){str[3]--;str[4]++;}else return -1;break;
                default :return -1;
            }
        }
        for(int i=0;i<4;i++) if(str[i]!=0) return -1;//如果k前面还有剩的字符就是残缺的蛙鸣
        return str[4];
    }
    public int minNumberOfFrogs2(String croakOfFrogs) {
        //吴小哲的思想：哈希表与数组映射
        //这个代码是我按照吴小哲的思想写的，但是我没有改变题目原本的参数，所以看起来难受些
        int n=croakOfFrogs.length();
        String croak="croak";
        int[] hash=new int[croak.length()];
        Map<Character,Integer> index=new HashMap<>();
        for(int i=0;i<croak.length();i++){
            char ch=croak.charAt(i);
            index.put(ch,i);//将蛙声的每个字符和数组下标绑定在一起
        }
        for(int i=0;i<n;i++){
            if(croakOfFrogs.charAt(i)==croak.charAt(0)){
                if(hash[croak.length()-1]>0) hash[croak.length()-1]--;
                hash[0]++;
            }else{
                char ch=croakOfFrogs.charAt(i);
                if(!index.containsKey(ch)) return -1;//蛙鸣里没有这个字符，返回-1
                if(hash[index.get(ch)-1]==0) return -1;//此字符的前一个字符还没出现，返回-1
                hash[index.get(ch)-1]--;//走到这里说明有这个字符，前一个也出现了
                hash[index.get(ch)]++;//让前--后++
            }
        }
        for(int i=0;i<hash.length-1;i++)
            if(hash[i]!=0)
                return -1;//筛一遍有没有漏下的
        return hash[croak.length()-1];
    }
}
