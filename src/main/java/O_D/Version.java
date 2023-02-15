package O_D;

/**
 * 获取最大软件版本号
 * Maven 版本号定义，<主版本>.<次版本>.<增量版本>-<里程碑版本>
 * 举例3.1.4-beta 其中，主版本和次版本都是必须的，主版本，次版本，增量版本由多位数字组成，可能包含前导零，里程碑版本由字符串组成。
 * <主版本>.<次版本>.<增量版本>：基于数字比较
 * 里程碑版本：基于字符串比较，采用字典序
 * 比较版本号时，按从左到右的顺序依次比较。
 *
 * 基于数字比较， 只需比较忽略任何前导零后的整数值 。
 * 输入2个版本号，输出最大版本号。
 *
 * 输入描述：
 *
 * 输入两个版本号，按行分割，每个版本号的长度小于50
 *
 * 输出描述：
 *
 * 输出较大的版本号
 *
 * 示例1：
 *
 * 输入：
 *
 * 2.5.1-C
 *
 * 1.4.2-D
 *
 * 输出：
 *
 * 2.5.1-C
 */
import java.util.Scanner;
public class Version {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String version1_str = in.nextLine();
            String[] version1 = version1_str.split("-");
            String[] version1_no = version1[0].split("\\.");
            String[] version1_info = new String[4];
            version1_info[0] = version1_no[0];
            version1_info[1] = version1_no[1];
            version1_info[2] = version1_no[2];
            version1_info[3] = version1[1];

            String version2_str = in.nextLine();
            String[] version2 = version2_str.split("-");
            String[] version2_no = version2[0].split("\\.");
            String[] version2_info = new String[4];
            version2_info[0] = version2_no[0];
            version2_info[1] = version2_no[1];
            version2_info[2] = version2_no[2];
            version2_info[3] = version2[1];

            if (comp(version1_info, version2_info)>=0) {
                System.out.print(version1_str);
            } else {
                System.out.print(version2_str);
            }

        }

        public static int comp(String[] a,String[] b) {
            if (a[0].equals(b[0])) {
                if (a[1].equals(b[1])) {
                    if (a[2].equals(b[2])) {
                        return a[3].compareTo(b[3]);
                    } else {
                        return a[2].compareTo(b[2]);
                    }
                } else {
                    return a[1].compareTo(b[1]);
                }
            } else {
                return a[0].compareTo(b[0]);
            }
        }

    }
}
