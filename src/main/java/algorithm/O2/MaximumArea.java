package algorithm.O2;

import java.util.Scanner;

/**
 * 计算最大乘积
 */
public class MaximumArea {
    static class Main {
        public static int max_product = 0;
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                String str = in.nextLine();
                String[] str_list = str.split(",");
                //暴力双循环
                for(int i=0;i<str_list.length;i++){
                    for(int j=i+1;j<str_list.length;j++){
                        get_max_product(str_list[i], str_list[j]);
                    }
                }
                System.out.println(max_product);
            }
        }

        public static void get_max_product(String a,String b){
            int product = a.length() * b.length();
            if(product <= max_product){
                return;
            }else{
                for(int i=0;i<a.length();i++){
                    for(int j=0;j<b.length();j++){
                        if(a.charAt(i)==b.charAt(j)){
                            return;
                        }
                    }
                }
                max_product = product;
            }
        }
    }
}
