package algorithm.O2;

/**
 *
 */
import java.util.*;
import java.util.stream.Collectors;
public class ShootingContest {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int n = Integer.parseInt(in.nextLine());
            List<Integer> ids = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> scores =  Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            in.close();

            // 存储选手成绩信息
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = map.getOrDefault(ids.get(i), new LinkedList<>());
                list.add(scores.get(i));
                map.put(ids.get(i), list);
            }

            StringBuilder builder = new StringBuilder();
            //过滤+自定义排序
            map.entrySet().stream()
                    .filter(x -> x.getValue().size() >= 3)
                    .sorted((o1, o2) -> {
                        Integer sum1 = get_sum_score(o1.getValue());
                        Integer sum2 = get_sum_score(o2.getValue());
                        if (sum1.equals(sum2)) {
                            return o2.getKey() - o1.getKey();
                        } else {
                            return sum2 - sum1;
                        }
                    })
                    .map(Map.Entry::getKey)
                    .forEach(x -> builder.append(x).append(","));

            System.out.println(builder.substring(0, builder.length() - 1));

        }

        private static Integer get_sum_score(List<Integer> list) {
            list.sort(Integer::compareTo);
            int sum = 0;
            for (int i = list.size() - 1; i >= list.size() - 3; i--) {
                sum += list.get(i);
            }
            return sum;
        }
    }
}
