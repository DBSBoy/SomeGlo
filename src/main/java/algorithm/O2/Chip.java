package algorithm.O2;

/**
 * 最优芯片资源占用
 */
import java.util.Scanner;
public class Chip {
    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int M = in.nextInt();
            int N = in.nextInt();
            String user_input = in.next();

            // 表示各个芯片的剩余总容量
            double[] used = new double[N];
            for (int i=0;i<N;i++) {
                used[i] = M*1.25;
            }

            // 按照用户配置分配每一个容量
            for(int i=0; i<user_input.length();i++) {
                double capacity = 0.0;
                if (user_input.charAt(i) == 'A') {
                    capacity = 1.25;
                } else if (user_input.charAt(i) == 'B') {
                    capacity = 2.5;
                } else {
                    capacity = 10;
                }

                // 从第一块芯片开始分配
                for (int j=0;j<N;j++) {
                    if (used[j] >= capacity) {
                        used[j] -= capacity;
                        break;
                    }
                }
            }

            //输出
            for (int j=0;j<N;j++) {
                String output_str="";

                for (int k=0;k<M-used[j]/1.25;k++) {
                    output_str += '1';
                }
                for (int i=0;i<used[j]/1.25;i++) {
                    output_str += "0";
                }
                System.out.println(output_str);
            }
        }


    }
}
