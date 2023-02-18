package algorithm.O2;

/**
 * 优秀学员统计
 * 公司某部门软件教导团正在组织新员工每日打卡学习活动，他们开展这项学习活动已经一个月了，所以想统计下这个月优秀的打卡员工。
 * 每个员工会对应一个id，每天的打卡记录记录当天打卡员工的id集合，，一共30天。
 * 请你实现代码帮助统计出打卡次数tp5的员工。加入打卡次数相同，将较早参与打卡的员工排在前面，如果开始参与打卡的时间还是一样，将id较小的员工排在前面。
 * 注:不考虑并列的情况，按规则返回前5名员工的id即可，如果当月打卡的员工少于5人，按规则排序返回所有有打卡记录的员工id.
 *
 *
 * 输入描述
 * 第一行输入为新员工数量N，表示新员工编号id为0到N-1，N的范围为[1,100]
 *
 * 第二行输入为30个整数，表示每天打卡的员工数量，每天至少有1名员工打卡.
 *
 * 之后30行为每天打卡的员工id集合，id不会重复。
 *
 * 输出描述
 * 按顺序输出打卡top5员工的id，用空格隔开。
 *
 * 示例1：
 * 输入
 *
 * 11
 * 4 4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
 * 0 1 7 10
 * 0 1 6 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 10
 * 6 10
 * 7 10
 *
 * 输出：
 * 10 0 1 7 6
 */
import java.util.Scanner;
import java.util.*;
public class OutstandingStudents {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            //新员工数量
            int n = in.nextInt();

            // 每天打卡的员工数量
            int[] employee_count = new int[30];
            for (int i = 0; i < 30; i++) {
                employee_count[i] = in.nextInt();
            }

            // 打卡记录
            int[][] employee_ids = new int[30][];
            for (int i = 0; i < 30; i++) {
                employee_ids[i] = new int[employee_count[i]];
                for (int j = 0; j < employee_count[i]; j++) {
                    employee_ids[i][j] = in.nextInt();
                }
            }

            //key为员工ID， value为其打卡的记录信息：[打卡次数，首次打卡index]
            HashMap<Integer, Integer[]> employee_info = new HashMap<>();

            for (int i = 0; i < employee_ids.length; i++) {
                for (int id : employee_ids[i]) {
                    if (employee_info.containsKey(id)) {
                        employee_info.get(id)[0]++;
                    } else {
                        employee_info.put(id, new Integer[] {1, i});
                    }
                }
            }

            // 将map信息转到list中，以便后续排序
            ArrayList<Integer[]> employee_list = new ArrayList<>();
            for (Integer id : employee_info.keySet()) {
                employee_list.add(new Integer[] {id, employee_info.get(id)[0], employee_info.get(id)[1]});
            }

            employee_list.sort((a, b) ->
                    a[1].equals(b[1]) ? (a[2].equals(b[2]) ? a[0] - b[0] : a[2] - b[2]) : b[1] - a[1]);


            //输出
            for (int i = 0; i < 5; i++) {
                System.out.print(employee_list.get(i)[0]);
                if (i!=4) {
                    System.out.print(" ");
                }
            }
        }


    }
}
