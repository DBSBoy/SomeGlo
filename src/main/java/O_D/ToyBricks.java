package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 积木最远距离
 */
public class ToyBricks {


    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int count = in.nextInt();

            HashMap<Integer, List<Integer>> blocks = new HashMap<Integer, List<Integer>>();
            for (int i = 0;i<count;i++) {
                int num = in.nextInt();
                if (blocks.containsKey(num)) {
                    List<Integer> block_pos = blocks.get(num);
                    block_pos.add(i);
                    blocks.put(num, block_pos);
                } else {
                    List<Integer> block_pos = new ArrayList<Integer>();
                    block_pos.add(i);
                    blocks.put(num, block_pos);
                }
            }

            int max_distance = -1;
            for (Map.Entry<Integer, List<Integer>> x : blocks.entrySet()) {
                if (x.getValue().size() > 1) {
                    max_distance = Math.max(max_distance, Collections.max(x.getValue()) - Collections.min(x.getValue()));
                }
            }
            System.out.println(max_distance);


        }
    }
}
