package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 146. LRU 缓存机制
 * @author jzt
 * @version 1.0
 * @date 2021/7/2 1:55 下午
 **/
public class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }
}
