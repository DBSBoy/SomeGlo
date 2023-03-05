package O_D;

/**
 * CPU调度
 * CPU同时只能运行一个任务，请编写一个任务调度程序，采用“可抢占优先权调度”调度算法进行任务调度，规则如下：
 * 1：如果一个任务到来时，CPU是空闲的，则CPU可以运行该任务直到任务执行完毕。但是如果运行中有一个更高优先级的任务到来，则CPU必须暂停当前任务去运行这个优先级更高的任务；
 * 2：如果一个任务到来时，CPU正在运行一个比他优先级更高的任务时，信道大的任务必须等待；
 * 3：当CPU空闲时，如果还有任务在等待，CPU会从这些任务中选择一个优先级最高的任务执行，相同优先级的任务选择到达时间最早的任务。
 * 输入描述
 * 输入有若干行，每一行有四个数字（均小于10^8）,分别为任务ID，任务优先级，执行时间和到达时间。每个任务的任务ID不同，优先级数字越大优先级越高，并且相同优先级的任务不会同时到达。
 * 输入的任务已按照到达时间从小到大排序，并且保证在任何时间，处于等待的任务不超过10000个。
 * 输出描述
 * 按照任务执行结束的顺序，
 * 示例一
 * 输入
 *
 * 1 3 5 1
 * 2 1 5 10
 * 3 2 7 12
 * 4 3 2 20
 * 5 4 9 21
 * 6 4 2 22
 * 输出
 *
 * 1 6
 * 3 19
 * 5 30
 * 6 32
 * 4 33
 * 2 35
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class SchedulingCpu {
    static class Main {

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            List<ArrayList<Long>> tasks = new ArrayList<ArrayList<Long>>();
            while(in.hasNextLine()) {
                List<Long> task = Arrays.stream(in.nextLine().split(" "))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                //System.out.println(Arrays.toString(task.toArray()));
                tasks.add(new ArrayList<>(task));
            }

            int time = 0;
            List<ArrayList<Long>> waiting = new ArrayList<ArrayList<Long>>();
            while (tasks.size() > 0) {
                ArrayList<Long> cur = find(tasks, time);

                if (cur != null) {
                    waiting.add(cur);
                    //按照优先级排序
                    Collections.sort(waiting, new Comparator<ArrayList<Long>>() {
                        @Override
                        public int compare(ArrayList<Long> o1, ArrayList<Long> o2) {
                            return  o2.get(1).compareTo(o1.get(1));
                        }
                    });
                    cur = waiting.get(0);
                } else {
                    if (waiting.size() != 0) {
                        cur = waiting.get(0);
                        //System.out.println(Arrays.toString(cur.toArray()));
                    }
                }

                if (cur != null) {
                    cur.set(2, cur.get(2) - 1);
                    if (cur.get(2) == 0) {
                        System.out.println(cur.get(0) + " " + (time + 1));
                        tasks.remove(cur);
                        waiting.remove(cur);
                    }
                }
                time++;
            }

        }

        public static ArrayList<Long> find(List<ArrayList<Long>> tasks, int time) {
            for (ArrayList<Long> task : tasks) {
                if (task.get(3) == time) {
                    return task;
                }
            }
            return null;
        }
    }
}
