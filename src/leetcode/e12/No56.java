package leetcode.e12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No56 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start != 0 ? o1.start-o2.start : o2.end-o1.end;
            }
        });

        boolean[] isMerged = new boolean[intervals.size()];
        for(int i = 0; i < intervals.size(); i++){
            if(!isMerged[i]) {
                Interval first = intervals.get(i);
                for (int j = i + 1; j < intervals.size(); j++) {
                    if(!isMerged[j]) {
                        Interval second = intervals.get(j);
                        if(first.end >= second.start){
                            if(first.end <= second.end){
                                first.end = second.end;
                            }
                            isMerged[j] = true;
                        }
                    }
                }
            }
        }

        List<Interval> result = new ArrayList<>();
        for(int i = 0; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(!isMerged[i])
                result.add(interval);
        }
        return result;
    }
}
