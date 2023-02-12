package algorithm.AlgoThinking.Recursion;

import java.util.HashMap;
import java.util.Map;

public class climbStairs {
    private  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climb(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 防止重复计算
        if (null != map.get(n))
            return map.get(n);
        else {
            int result = climb(n-1) + climb(n - 2);
            map.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        climbStairs cs = new climbStairs();
        System.out.println(cs.climb(6));
    }
}
