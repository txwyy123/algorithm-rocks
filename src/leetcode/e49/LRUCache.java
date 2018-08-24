package leetcode.e49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/24.
 */
public class LRUCache {

    List<Integer> list;
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == key){
                    list.remove(i);
                    list.add(0, key);
                    break;
                }
            }
            result = map.get(key);
        }
        return result;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == key){
                    list.remove(i);
                    list.add(0, key);
                    break;
                }
            }
        }else if(list.size() >= capacity){
            map.remove(list.get(list.size()-1));
            list.remove(list.size()-1);
            list.add(0, key);
        }else{
            list.add(0, key);
        }
        map.put(key, value);
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(1);
        cache.get(1);       // returns 1
    }
}
