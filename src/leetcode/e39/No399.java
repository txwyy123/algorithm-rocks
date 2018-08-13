package leetcode.e39;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/12.
 */
public class No399 {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations==null || equations.length==0) return new double [] {};

        Map<String, String>root=new HashMap<>();
        Map<String, Double>map=new HashMap<>();

        for (int i=0;i<equations.length;i++){
            String x1=equations[i][0], x2=equations[i][1];
            root.putIfAbsent(x1, x1);
            root.putIfAbsent(x2, x2);
            map.putIfAbsent(x1, 1.0);
            map.putIfAbsent(x2, 1.0);

            String r1=find(root, x1);
            String r2=find(root, x2);
            root.put(r2, r1);
            map.put(r2, map.get(x1)*values[i]/map.get(x2));
        }

        double[] res=new double[queries.length];
        for (int i=0;i<queries.length;i++){
            res[i]=-1.0;
            String x1=queries[i][0], x2=queries[i][1];
            if (!root.containsKey(x1) || !root.containsKey(x2)) continue;
            String r1=find(root, x1);
            String r2=find(root, x2);
            if (r1.equals(r2))
                res[i]=get(root, map, x2) / get(root, map, x1);
        }
        return res;
    }

    private String find(Map<String, String>root, String var){
        if (root.get(var).equals(var)) return var;
        return find(root, root.get(var));
    }

    private double get(Map<String, String>root, Map<String, Double>map, String var){
        String r=root.get(var);
        double result=map.get(var);

        if (r.equals(var)) return result;
        return result*get(root, map, r);
    }

    public static void main(String[] args){
        No399 no399 = new No399();
        String[][] equations = {{"a","b"}, {"c","d"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        no399.calcEquation(equations, values, queries);
    }
}
