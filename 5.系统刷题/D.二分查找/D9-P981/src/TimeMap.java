import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-15
 * Time: 21:50
 */
//981. 基于时间的键值存储
class TimeMap {
    //存<字符串键，<时间戳，数值>>Tree会天然按时间戳升序排序
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    public String get(String key, int timestamp) {
        //获取key对应的TreeMap，如果不存在就默认一个空的TreeMap，避免空指针
        //floorEntry(timestamp)：TreeMap的核心方法，返回<=timestamp的最大键对应的键值对Entry
        Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
class Pair{
    int timestamp;
    String value;
    //构造函数，构建一个Pair
    public Pair(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}
class TimeMap {
    Map<String, List<Pair>> hash;
    public TimeMap() {
        this.hash=new HashMap<String,List<Pair>>();
    }
    //一个hash，键值是key，通过key找到Pair集合（类似TreeMap）,根据Pair集合的时间戳找到目标值
    //因为timestamp递增的特性，所以天然升序排序（无需排序再二分）
    public void set(String key, String value, int timestamp) {
        Pair pair=new Pair(timestamp,value);
        List<Pair> pairs=hash.getOrDefault(key,new ArrayList<Pair>());
        pairs.add(pair);//追加到key的后面
        hash.put(key,pairs);//重新放进哈希表
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs=hash.getOrDefault(key,new ArrayList<Pair>());
        if(pairs.isEmpty()) return "";
        //找已存的最大的timestamp,求最右端点模型
        int left=0,right=pairs.size()-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            //这里的get是List内置的，不是Pair的
            //pairs.get(mid)含义：获取pairs列表中，下标为mid的那个Pair对象
            if(pairs.get(mid).timestamp>timestamp) right=mid-1;
            else left=mid;
        }
        if(pairs.get(left).timestamp<=timestamp) return pairs.get(left).value;
        //前一个if没走，说明所有元素都大于timestamp,就是说都是在该时间戳之后set新添的元素，目前这个时间戳还没set过
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */