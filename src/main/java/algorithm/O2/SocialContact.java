package algorithm.O2;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 最大社交距离
 */
public class SocialContact {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int seat_num = in.nextInt();
        in.nextLine();
        String seat_str = in.nextLine();
        String[] seats = seat_str.substring(1, seat_str.length() - 1).split(",");
        int[] seat_status = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            seat_status[i] = Integer.parseInt(seats[i]);
        }
        System.out.print(get_distance(seat_num, seat_status));
    }

    public static int get_distance(int seat_num, int[] seat_status) {
        TreeSet<Integer> taken_seats = new TreeSet<>();
        for (int i = 0; i < seat_status.length; i++) {
            int op = seat_status[i];
            if (op > 0) {
                if (taken_seats.size() == 0) {
                    if (i == seat_status.length - 1) {
                        return 0;
                    }
                    taken_seats.add(0);
                } else if (taken_seats.size() == 1) {
                    taken_seats.add(seat_num - 1);
                    if (i == seat_status.length - 1) {
                        return seat_num - 1;
                    }
                } else if (taken_seats.size() > 1 && taken_seats.size() < seat_num) {
                    int[] ints = new int[taken_seats.size()];
                    int count = 0;
                    for (Integer taken_seat : taken_seats) {
                        ints[count++] = taken_seat;
                    }
                    int max_len = 0;
                    int start = 0;
                    for (int j = 0; j < ints.length - 1; j++) {
                        int len = ints[j + 1] - ints[j];
                        if (len / 2 > max_len) {
                            max_len = len / 2;
                            start = ints[j];
                        }
                    }
                    taken_seats.add(start + max_len);
                    if (i == seat_status.length - 1) {
                        return start + max_len;
                    }
                } else {
                    return -1;
                }
            } else {
                taken_seats.remove(-op);
            }
        }
        return 0;
    }
}
