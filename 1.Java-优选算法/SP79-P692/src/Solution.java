import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-18
 * Time: 19:58
 */
class Solution {
    //692. 前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //先统计频率
        Map<String,Integer> hash=new HashMap<>();
        for(String s:words) hash.put(s,hash.getOrDefault(s,0)+1);
        //建堆
        PriorityQueue<Map.Entry<String,Integer>> heap=//<Map.Entry>而不是<Map>,不用Map.Entry用Pair也行
                new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){//<Map.Entry>而不是<Map>
                    @Override
                    public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                        if(o1.getValue().compareTo(o2.getValue())==0)
                            return o2.getKey().compareTo(o1.getKey());//比较的是字典顺序的"差值"，是int
                        return o1.getValue().compareTo(o2.getValue());//比较的是频率的"差值"，也是int
                    }
                });
        //放堆里
        for(Map.Entry<String,Integer> entry:hash.entrySet()){//<Map.Entry>而不是<Map>
            //取元素的地方是hash.entrySet()，而不是Map.Entry
            heap.offer(entry);
            if(heap.size()>k) heap.poll();
        }
        List<String> ret=new ArrayList<>();
        while(!heap.isEmpty()){
            String tmp=heap.poll().getKey();
            ret.add(tmp);
        }
        Collections.reverse(ret);
        return ret;
    }
}