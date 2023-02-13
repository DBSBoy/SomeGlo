package O_D;

/**
 * 货币单位换算
 * 输入:
 * 100CNY
 * 输出:
 * 10000
 * 说明:
 * 100CNY转换后是10000fen，所以输出结果为10000
 * 示例2
 * 输入:
 * 3000fen
 * 输出:
 * 3000
 * 说明:
 * 3000fen，结果就是3000
 *
 * 示例3
 * 输入:
 * 123HKD
 * 输出:
 * 10000
 * 说明:
 * HKD与CNY的汇率关系是123:100，所以换算后，输出结果为10000
 * 示例4
 * 输入:
 * 2
 * 20CNY53fen
 * 53HKD87cents
 * 输出:
 * 6432
 */
import java.util.Scanner;
public class Money {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();

            double result = 0;
            in.nextLine();
            for(int i=0;i<N;i++){
                // 字符串换算大小
                result += exchange(in.nextLine());
            }

            System.out.println((int)result);

        }

        public static double exchange(String str){
            String temp = "";
            double money = 0;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(Character.isDigit(c)){
                    temp += c;
                }else {
                    if(temp == ""){
                        continue;
                    }
                    money += transform( temp, c);
                    i += 2;     // 因为货币的简写至少为3位，所以可以跳两位
                    temp = "";
                }
            }

            return money;

        }

        public static double transform(String numStr, char str){
            double money = 0;
            int num = Integer.valueOf(numStr);
            if(str == 'C'){
                money = num * 100;
            }else if(str == 'J'){
                money = (double) num * 10000 / 1825;
            }else if(str == 'H'){
                money = (double) num * 10000 / 123;
            }else if(str == 'E'){
                money = (double) num * 10000 / 14;
            }else if(str == 'G'){
                money = (double) num * 10000 / 12;
            }else if(str == 'f'){
                money = num * 1;
            }else if(str == 's'){
                money = (double) num * 100 / 1825;
            }else if(str == 'c'){
                money = (double) num * 100 / 123;
            }else if(str == 'e'){
                money = (double) num * 100 / 14;
            }else if(str == 'p'){
                money = (double) num * 100 / 12;
            }

            return money;
        }

    }
}
