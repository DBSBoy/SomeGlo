package algorithm.O2;

import java.util.Scanner;

/**
 * 靠谱的车
 */
public class Reliable {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int price_after = in.nextInt();
        int ans = price_after;

        // k 表示当前跳过了多少个4
        // j 表示当前位数
        int skip_money = 0, k = 0, j = 1;
        while (price_after > 0) {
            //当前位上出现了4就 +1 (并考虑当前的位数)
            if (price_after % 10 > 4) {
                skip_money += (price_after % 10 - 1) * k + j;
            } else {
                skip_money += (price_after % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            price_after /= 10;
        }
        System.out.println(ans - skip_money);
    }
}
