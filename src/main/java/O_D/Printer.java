package O_D;
import java.util.Scanner;
import java.util.*;

/**
 * 打印机队列
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
