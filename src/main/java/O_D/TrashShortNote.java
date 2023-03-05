package O_D;

/**
 * 垃圾短信识别
 * 大众对垃圾短信深恶痛绝，希望能对垃圾短信发送者进行识别，为此，很多软件增加了垃圾短信的识别机制。经分析，发现正常用户的短信通常具备交互性，而垃圾短信往往都是大量单向的短信，按照如下规则进行垃圾短信识别:
 * 本题中，发送者A符合以下条件之一的，则认为A是垃圾短信发送者:
 * 1：A发送短信的接收者中，没有发过短信给A的人数L> 5;
 * 2：A发送的短信数 -A接收的短信数M > 10;
 * 3：如果存在X，A发送给X的短信数 - A接收到X的短信数N >5.
 * 输入描述
 * 第一行是条目数，接下来几行是具体的条目，每个条目，是一对D，第一人数字是发送者ID，后面的数字是接收者ID，中间空格隔开，所有的ID都为 无符号整型Q，ID最大值为100:
 * 同一个条目中，两个ID不会相同 (即不会自己给自己发消息)
 * 最后一行为指定的ID
 *
 * 输出描述
 * 输出该ID是否为垃圾短信发送者，并且按序列输出 L M 的值(由于 N 值不唯一，不需要输出)输出均为字符串。
 *
 * 示例1：
 *
 * 输入
 * 15
 *
 * 1 2
 *
 * 1 3
 *
 * 1 4
 *
 * 1 5
 *
 * 1 6
 *
 * 1 7
 *
 * 1 8
 *
 * 1 9
 * 1 10
 * 1 11
 * 1 12
 * 1 13
 * 1 14
 * 14 1
 * 1 15
 *
 * 1
 * 输出
 * true 13 13
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class TrashShortNote {


    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            int[][] id_pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                id_pairs[i][0] = in.nextInt();
                id_pairs[i][1] = in.nextInt();
            }

            int id = in.nextInt();

            //发送短信和收到短信的统计信息
            LinkedList<Integer> send_list = new LinkedList<>();
            LinkedList<Integer> receive_list = new LinkedList<>();

            // key为指定ID, value为其send的个数
            HashMap<Integer, Integer> send_map = new HashMap<>();
            // key为指定ID, value为其receive 的个数
            HashMap<Integer, Integer> receive_map = new HashMap<>();

            for (int[] id_pair : id_pairs) {
                int sender = id_pair[0];
                int receiver = id_pair[1];

                if (sender == id) {
                    send_list.addLast(receiver);
                    send_map.put(receiver, send_map.getOrDefault(receiver, 0) + 1);
                }

                if (receiver == id) {
                    receive_list.addLast(sender);
                    receive_map.put(sender, receive_map.getOrDefault(sender, 0) + 1);
                }
            }

            // 去重结果
            HashSet<Integer> send_set = new HashSet<>(send_list);
            HashSet<Integer> receive_set = new HashSet<>(receive_list);

            // 交集
            List<Integer> intersect = send_list.stream().filter(receive_set::contains).collect(Collectors.toList());

            // 两个指标 L & M
            int L = send_set.size() - intersect.size();
            int M = send_list.size() - receive_list.size();

            boolean flag = false;
            if (L > 10 || M > 5) {
                flag = true;
            }

            if (!flag) {
                // 指标 N
                for (Integer single_id : intersect) {
                    if (send_map.containsKey(single_id)
                            && receive_map.containsKey(single_id)
                            && send_map.get(single_id) - receive_map.get(single_id) > 5) {

                        flag = true;
                        break;
                    }
                }
            }

            System.out.println(flag + " " + L + " " + M);

        }

    }
}
