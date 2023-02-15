package O_D;

/**
 * 打卡
 * 考勤记录是分析和考核职工工作时间利用情况的原始依据，也是计算职工工资的原始依据，为了正确地计算职工工资和监督工资基金使用情况，公司决定对员工的手机打卡记录进行异常排查。
 * 如果出现以下两种情况，则认为打卡异常
 * 1.实际设备号与注册设备号不一样
 * 2.或者，同一个员工的两个打卡记录的时间小于60分钟并且打卡距离超过5km。
 * 给定打卡记录的字符串数组clockRecords (每个打卡记录组成为: 工号:时间 (分钟);打距离(km);实际设备号;注册设备号)，返回其中异常的打卡记录(按输入顺序输出)。
 * 输入描述
 * 第一行输入一个数字N，为打卡记录的条数。
 *
 * 后续N行记录分别表示打卡记录：工号:时间 (分钟);打距离(km);实际设备号;注册设备号，以逗号间隔。
 * 输出描述
 * 输出异常的打卡记录，以冒号间隔。若无异常打卡记录，则输出字符串null
 *
 * 示例1：
 * 输入
 *
 * 2
 * 100000,10,1,ABCD,ABCD
 * 100000,50,10,ABCD,ABCD
 * 输出
 *
 * 100000,10,1,ABCD,ABCD:100000,50,10,ABCD,ABCD
 */
import java.util.*;
public class PunchCard {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            String[][] clock_records = new String[n][];
            for (int i = 0; i < n; i++) {
                clock_records[i] = in.nextLine().split(",");
            }

            // 存放每位员工的打卡记录
            HashMap<String, ArrayList<String[]>> record_map = new HashMap<>();
            TreeSet<Integer> result = new TreeSet<>();

            // 初始化map时实现异常规则1
            for (int i = 0; i < clock_records.length; i++) {
                // 题目要求按输入顺序输出，加一个索引 i
                String[] single_record = Arrays.copyOf(clock_records[i], clock_records[i].length + 1);
                single_record[single_record.length - 1] = i + "";

                if (!single_record[3].equals(single_record[4])) {
                    result.add(i);
                } else {
                    if (record_map.containsKey(single_record[0])) {
                        record_map.get(single_record[0]).add(single_record);
                    } else {
                        record_map.put(single_record[0], new ArrayList<>());
                        record_map.get(single_record[0]).add(single_record);
                    }
                }
            }

            // 异常规则2
            for (String id : record_map.keySet()) {
                ArrayList<String[]> records = record_map.get(id);

                // 用打卡时间来排序，以加速后续的双层循环。
                records.sort((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

                for (int i = 0; i < records.size(); i++) {
                    int time1 = Integer.parseInt(records.get(i)[1]);
                    int dist1 = Integer.parseInt(records.get(i)[2]);

                    for (int j = i + 1; j < records.size(); j++) {
                        int time2 = Integer.parseInt(records.get(j)[1]);
                        int dist2 = Integer.parseInt(records.get(j)[2]);

                        // 如果当前的两次打卡时间超过60分, 那么后面的肯定也超过60分钟了
                        if (time2 - time1 >= 60) {
                            break;
                        } else {
                            if (Math.abs(dist2 - dist1) > 5) {
                                result.add(Integer.parseInt(records.get(i)[5]));
                                result.add(Integer.parseInt(records.get(j)[5]));
                            }
                        }
                    }
                }
            }

            // 输出
            if (result.size() == 0){
                System.out.println("null");
            } else {
                String res_str = "";
                for (int index : result) {
                    res_str += join(clock_records[index]) + ";";
                }
                System.out.println(res_str.substring(0, res_str.length()-1));
            }

        }

        //join输出
        public static String join(String[] strs){
            String s = "";
            for (String str : strs) {
                s+=str+",";
            }
            return s.substring(0, s.length()-1);
        }
    }
}
