package algorithm.O2;

import java.util.Scanner;

/**
 * 拼接url
 */
public class url {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] url_strs = in.nextLine().split(",");
        StringBuilder result = new StringBuilder();
        if (url_strs.length == 0) {
            System.out.println("/");
            return;
        }
        result.append("/");
        result.append(url_strs[0]);
        result.append("/");
        result.append(url_strs[1]);
        System.out.println((result.toString()).replaceAll("/+", "/"));

    }
}
