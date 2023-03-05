package algorithm.O2;

/**
 * 仿 LISP 运算
 */
import java.util.Scanner;
import java.util.*;

public class LISP {
    public static class Main {
        //标记是否合法表达式
        public static boolean error_flag;

        public static void main(String[] args) {
            //处理输入
            Scanner in = new Scanner(System.in);
            String lisp_str = in.nextLine().replaceAll("\\(", "( ").replaceAll("\\)", " )");
            String[] lisp_params = lisp_str.split(" ");

            Stack<String> patten = new Stack<>();
            Stack<String> opera = new Stack<>();

            int op1, op2;
            String operation;
            error_flag = false;
            int res = 0;
            for (int i = 0; i < lisp_params.length; i++) {
                //分支判定各字符
                switch (lisp_params[i]) {
                    case "(":
                        patten.push("(");
                        break;
                    case ")":
                        if (patten.isEmpty()) {
                            error_flag = true;
                        }
                        patten.pop();
                        op2 = Integer.parseInt(opera.pop());
                        op1 = Integer.parseInt(opera.pop());
                        operation = opera.pop();
                        res = cal(operation, op1, op2);
                        opera.push(String.valueOf(res));
                        break;
                    default:
                        opera.push(lisp_params[i]);
                }
                if(error_flag) {
                    break;
                }
            }
            if (error_flag) {
                System.out.println("error");
            } else {
                System.out.println(res);
            }
        }
        public static int cal(String operation, int op1, int op2) {
            int result = 0;
            switch (operation) {
                case "add":
                    result = op1 + op2;
                    break;
                case "sub":
                    result = op1 - op2;
                    break;
                case "mul":
                    result = op1 * op2;
                    break;
                default:
                    if (op2 == 0) {
                        error_flag = true;
                    } else {
                        result = op1 / op2;
                    }
            }
            return result;
        }

    }

}
