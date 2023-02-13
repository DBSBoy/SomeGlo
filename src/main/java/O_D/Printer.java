package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 打印机队列
 * 有5台打印机打印文件，每台打印机有自己的待打印队列。因为打印的文件内容有轻重缓急之分，
 *
 * 所以队列中的文件有1~10不同的代先级，其中数字越大优先级越高。
 *
 * 打印机会从自己的待打印队列中选择优先级最高的文件来打印。
 *
 * 如果存在两个优先级一样的文件，则选择最早进入队列的那个文件。
 *
 * 现在请你来模拟这5台打印机的打印过程。
 *
 * 输入描述
 *
 * 每个输入包含1个测试用例，每个测试用例第一行给出发生事件的数量N（0 < N < 1000）。
 * 接下来有 N 行，分别表示发生的事件。
 * 共有如下两种事件：
 * 1. “IN P NUM”，表示有一个拥有优先级 NUM 的文件放到了打印机 P 的待打印队列中。（0< P <= 5, 0 < NUM <= 10)；
 * 2. “OUT P”，表示打印机 P 进行了一次文件打印，同时该文件从待打印队列中取出。（0 < P <= 5）。
 *
 * 输出描述
 *
 * 对于每个测试用例，每次”OUT P”事件，请在一行中输出文件的编号。
 * 如果此时没有文件可以打印，请输出”NULL“。
 * 文件的编号定义为”IN P NUM”事件发生第 x 次，此处待打印文件的编号为x。编号从1开始。
 *
 * 示例1   输入输出示例仅供调试，后台判断数据一般不包含示例
 *
 * 输入
 *
 * 7
 * IN 1 1
 * IN 1 2
 * IN 1 3
 * IN 2 1
 * OUT 1
 * OUT 2
 * OUT 2
 *
 * 输出
 *
 * 3
 * 4
 * NULL
 */
public class Printer {


    public static class Main {
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int count = in.nextInt();
            in.nextLine();

            //5台打印机的打印清单
            //使用匿名内部类创建Comparator实现类，重写compare方法
            TreeSet<ArrayList<Integer>> print_machine= new TreeSet<>(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int result = o2.get(0) - o1.get(0);
                    if (result == 0) {
                        return  o1.get(1) - o2.get(1);
                    }
                    return result;
                }
            });
            List<TreeSet<ArrayList<Integer>>> print_machines = new ArrayList<TreeSet<ArrayList<Integer>>>();

            //不想改序号了，按题目要求是从1开始编号的，但是多一个也无妨
            for (int i=0;i<=5;i++) {
                print_machines.add(new TreeSet<>(new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                        int result = o2.get(0) - o1.get(0);
                        if (result == 0) {
                            return o1.get(1) - o2.get(1);
                        }
                        return result;
                    }
                }));
            }

            int file_count = 0;
            for (int i=0;i< count;i++) {
                String[] operation_info = in.nextLine().split(" ");

                if (operation_info[0].equals("IN")) {
                    file_count += 1;
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(Integer.parseInt(operation_info[2]));
                    temp.add(file_count);
                    //放入文件
                    print_machines.get(Integer.parseInt(operation_info[1])).add(temp);
                } else {
                    //打印
                    if (print_machines.get(Integer.parseInt(operation_info[1])).size() > 0) {
                        System.out.println(print_machines.get(Integer.parseInt(operation_info[1])).first().get(1));
                        print_machines.get(Integer.parseInt(operation_info[1])).pollFirst();
                    } else {
                        System.out.println("NULL");
                    }
                }

            }
        }
    }
}
