package od2;

import java.util.Scanner;

/**
 * 五键盘
 */
public class keyBord {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String[] operation_list = in.nextLine().split(" ");

        StringBuilder res_str = new StringBuilder();

        String choose = "";
        String tab = "";

        for (String op : operation_list) {
            switch (op) {
                case "1":
                    choose = reset(res_str, choose);
                    res_str.append('A');
                    break;
                case "2":
                    if (!choose.isEmpty()) {
                        tab = choose;
                    }
                    break;
                case "3":
                    if (!choose.isEmpty()) {
                        tab = choose;
                        choose = "";
                        res_str = new StringBuilder();
                    }
                    break;
                case "4":
                    choose = reset(res_str, choose);
                    res_str.append(tab);
                    break;
                case "5":
                    if (res_str.length() != 0) {
                        choose = res_str.toString();
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(res_str.length());
    }

    private static String reset(StringBuilder res_str, String choose) {
        if (!choose.isEmpty()) {
            res_str.replace(0, choose.length(), "");
            choose = "";
        }
        return choose;
    }
    }
