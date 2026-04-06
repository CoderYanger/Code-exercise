import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-05
 * Time: 22:28
 */
class Solution {
    //3799. 单词方块 II
    public List<List<String>> wordSquares(String[] words) {
        //存储单词，方便快速检查存在性
        Set<String> wordSet=new HashSet<>();
        //手动把word数组的元素添加到Set里
        for(String word:words) wordSet.add(word);
        List<List<String>> ret=new ArrayList<>();
        //遍历所有可能的top、left、right、bottom组合
        for(String top:words){
            for(String left:words){
                //确保top和left不同
                if(top.equals(left)) continue;
                //检查约束：top[0]==left[0]
                if(top.charAt(0)!=left.charAt(0)) continue;
                for(String right:words){
                    //确保right与top、left都不同
                    if(top.equals(right)||right.equals(left)) continue;
                    //检查约束：top[3]==right[0]
                    if(top.charAt(3)!=right.charAt(0)) continue;
                    //确定bottom需要满足的首字符和尾字符
                    char bottomFirst=left.charAt(3);
                    char bottomLast=right.charAt(3);
                    for(String bottom:words){
                        //确保bottom与top、left、right都不同
                        if(bottom.equals(top)||bottom.equals(left)||bottom.equals(right)) continue;
                        //检查约束：bottom[0]==left[3]且bottom[3]==right[3]
                        if(bottom.charAt(0)==bottomFirst&&bottom.charAt(3)==bottomLast){
                            //手动创建List并添加四个单词
                            List<String> q=new ArrayList<>();
                            q.add(top);q.add(left);q.add(right);q.add(bottom);
                            ret.add(q);
                        }
                    }
                }
            }
        }
        //比较规则，在上左右下的框架下，从每组的首单词一次开始往后按字典学比较排序
        Collections.sort(ret,new Comparator<List<String>>(){
            @Override
            public int compare(List<String> a,List<String> b){
                for(int i=0;i<4;i++){
                    int cmp=a.get(i).compareTo(b.get(i));
                    if(cmp!=0) return cmp;
                }
                return 0;
            }
        });
        return ret;
    }
}
