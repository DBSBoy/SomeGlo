package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 二元组
 */
public class twoTuples {


    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int m = in.nextInt();

            //创建hash结构
            HashMap<Integer,Integer> m_info = new HashMap<Integer, Integer>();
            for (int i = 0;i<m;i++) {
                int num = in.nextInt();
                if (m_info.containsKey(num)) {
                    m_info.put(num, m_info.get(num) + 1);
                } else {
                    m_info.put(num, 1);
                }
            }

            int n = in.nextInt();

            HashMap<Integer,Integer> n_info = new HashMap<Integer, Integer>();
            for (int i = 0;i<n;i++) {
                int num = in.nextInt();
                if (n_info.containsKey(num)) {
                    n_info.put(num, n_info.get(num) + 1);
                } else {
                    n_info.put(num, 1);
                }
            }

            //算对数
            long result = 0;
            for (Map.Entry<Integer, Integer> x : m_info.entrySet()) {
                if (n_info.containsKey(x.getKey())) {
                    result += x.getValue() * n_info.get(x.getKey());
                }
            }
            System.out.println(result);


        }
    }
}
