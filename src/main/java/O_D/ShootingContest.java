package O_D;

/**
 * 投篮比赛
 * 你现在是一场采用特殊赛制投篮大赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。
 * 你会得到一个记录操作的字符串列表 ops，其中ops[i]是你需要记录的第i项操作，ops遵循下述规则：
 *
 * 整数x-表示本回合新获得分数x
 * “+” – 表示本回合新获得的得分是前两次得分的总和。
 * “D” – 表示本回合新获得的得分是前一次得分的两倍。
 * “C” – 表示本回合没有分数，并且前一次得分无效，将其从记录中移除。
 * 请你返回记录中所有得分的总和。
 *
 * 示例1：
 *
 * 输入：5 2 C D +
 * 输出：30
 * 解释：
 * “5”-记录加5，记录现在是[5]
 * “2”-记录加2，记录现在是[5,2]
 * “C”-使前一次得分的记录无效并将其移除，记录现在是[5].
 * “D”-记录加2*5=10，记录现在是[5，10].
 * “+”-记录加5+10=15，记录现在是[5，10，15].
 * 所有得分的总和5+10+15=30
 */
import java.util.Scanner;
import java.util.*;
public class ShootingContest {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String[] params = in.nextLine().split(" ");

            List<Integer> scores = new ArrayList<>();
            for (int i=0;i<params.length;i++) {
                if (params[i].equals("+")) {
                    scores.add(scores.get(scores.size()-2) + scores.get(scores.size()-1));
                } else if (params[i].equals("D")) {
                    scores.add(2*scores.get(scores.size()-1));
                } else if (params[i].equals("C")) {
                    scores.remove(scores.size() - 1);
                } else {
                    scores.add(Integer.parseInt(params[i]));
                }
            }

            System.out.println(scores.stream().reduce(Integer::sum).get());
        }

    }
}
