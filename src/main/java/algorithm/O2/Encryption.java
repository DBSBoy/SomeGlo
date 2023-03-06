package algorithm.O2;

import java.util.Scanner;

/**
 * 字符串加密
 */
public class Encryption {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            // 偏移数组大小
            int max = 4;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine();
                max = Math.max(max, arr[i].length());
            }
            // 偏移数组
            int[] offsetArr = new int[max];
            offsetArr[0] = 1;
            offsetArr[1] = 2;
            offsetArr[2] = 4;
            for (int i = 3; i < max; i++) {
                offsetArr[i] = offsetArr[i - 1] + offsetArr[i - 2] + offsetArr[i - 3];
            }
            for (int i = 0; i < n; i++) {
                String str = arr[i];
                StringBuilder resStr = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    // 取余，避免溢出
                    int res = (str.charAt(j) - 'a' + offsetArr[j]) % 26 + 'a';
                    resStr.append((char) res);
                }
                System.out.println(resStr);
            }
        }
        in.close();
    }
}
