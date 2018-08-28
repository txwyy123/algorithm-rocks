package leetcode.e52;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/27.
 */
public class LFUCache {

    class Element{
        int key;
        int value;
        int count;
    }

    List<Element> elements;
    Map<Integer, Element> map;
    int capacity;

    public LFUCache(int capacity) {
        this.elements = new ArrayList<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        if(capacity <= 0)
            return result;

        if(map.containsKey(key)){
            Element element = map.get(key);
            result = element.value;
            element.count++;

            int index = 0;
            int pos = 0;
            boolean indexSet = false;
            boolean posSet = false;
            for(int i = 0; i <= elements.size(); i++){
                if((i == elements.size() || elements.get(i).count <= element.count) && !indexSet) {
                    index = i;
                    indexSet = true;
                }
                if(i < elements.size() && elements.get(i).key == key && !posSet) {
                    pos = i;
                    posSet = true;
                }
            }
            elements.remove(pos);
            if(index > pos)
                elements.add(index-1, element);
            else
                elements.add(index, element);
        }
        return result;
    }

    public void put(int key, int value) {
        if(capacity <= 0)
            return;

        if(map.containsKey(key)){
            Element element = map.get(key);
            element.value = value;
            element.count++;

            int index = 0;
            int pos = 0;
            boolean indexSet = false;
            boolean posSet = false;
            for(int i = 0; i <= elements.size(); i++){
                if((i == elements.size() || elements.get(i).count <= element.count) && !indexSet) {
                    index = i;
                    indexSet = true;
                }
                if(i < elements.size() && elements.get(i).key == key && !posSet) {
                    pos = i;
                    posSet = true;
                }
            }
            elements.remove(pos);
            if(index > pos)
                elements.add(index-1, element);
            else
                elements.add(index, element);
        }else {
            Element element = new Element();
            element.key = key;
            element.value = value;
            element.count = 1;

            if(elements.size() >= capacity) {
                Element removed = elements.remove(elements.size()-1);
                map.remove(removed.key);
            }
            int index = 0;
            for(int i = 0; i <= elements.size(); i++){
                if(i == elements.size() || elements.get(i).count <= element.count) {
                    index = i;
                    break;
                }
            }
            elements.add(index, element);
            map.put(key, element);
        }
    }

    public static void main(String[] args){
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        cache.get(0);
    }
}
