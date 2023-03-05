package O_D;

/**
 * 仿照Excel的这个功能，请对给定表格中选中区域中的单元格进行求和统计，并输出统计结果。
 * 为简化计算，假设当前输入中每个单元格内容仅为数字或公式两种。
 * ● 如果为数字，则是一个非负整数，形如3、77
 * ● 如果为公式，则固定以=开头，且仅包含下面三种情况：
 *
 * 1.等于某单元格的值，例如=B12
 * 2.两个单元格的双目运算（仅为+或-），形如=C1-C2、C3+B2
 * 3.单元格和数字的双目运算（仅为+或-），形如=B1+1、100-B2
 *
 * 注意：
 *
 * 公式内容都是合法的，例如不存在，=C+1、=C1-C2+B3,=5、=3+5
 * 不存在循环引用，例如A1=B1+C1、C1=A1+B2
 * 内容中不存在空格、括号
 * 输入描述：
 *
 * 第一行两个整数rows cols，表示给定表格区域的行数和列数，1<=rows<=20，1<=cols<=26。
 * 接下来rows行，每行cols个以空格分隔的字符串，表示给定表格values的单元格内容。
 * 最后一行输入的字符串，表示给定的选中区域，形如A1:C2。
 *
 * 输出描述：
 *
 * 一个整数，表示给定选中区域各单元格中数字的累加总和，范围-2,147,483,648 ~ 2,147,483,647
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1 3
 * 1 =A1+C1 3
 * A1:C1
 *
 * 输出
 *
 * 8
 */
import java.util.Scanner;
public class Excel {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String[] params = in.nextLine().split(" ");
            int rows = Integer.parseInt(params[0]);
            int cols = Integer.parseInt(params[1]);

            String[][] matrix = new String[rows][cols];
            for (int i=0;i<rows;i++) {
                matrix[i] = in.nextLine().split(" ");
            }

            // 先将表达式都转为数字字符串
            for (int i=0;i<rows;i++) {
                for (int j=0;j<cols;j++) {
                    if (matrix[i][j].charAt(0) == '=') {
                        if (matrix[i][j].contains("+")) {
                            String[] op = matrix[i][j].split("\\+");
                            String op1 = op[0];
                            String op2 = op[1];

                            int num1,num2;
                            //假如是纯数字,就直接用
                            if (op1.substring(1).matches("-?\\d+(\\.\\d+)?")) {
                                num1 = Integer.parseInt(op1.substring(1));
                            } else {
                                //否则到martix中找到对应的数字
                                num1 = Integer.parseInt(matrix[Integer.parseInt(op1.substring(2)) - 1][(int)op1.charAt(1)-65]);
                            }

                            if (op2.matches("-?\\d+(\\.\\d+)?")) {
                                num2 = Integer.parseInt(op2);
                            } else {
                                num2 = Integer.parseInt(matrix[Integer.parseInt(op2.substring(1))-1][(int)op2.charAt(0)-65]);
                            }

                            matrix[i][j] = String.valueOf(num1 + num2);
                        } else if (matrix[i][j].contains("-")) {
                            String[] op = matrix[i][j].split("-");
                            String op1 = op[0];
                            String op2 = op[1];
                            int num1,num2;
                            if (op1.substring(1).matches("-?\\d+(\\.\\d+)?")) {
                                num1 = Integer.parseInt(op1.substring(1));
                            } else {
                                num1 = Integer.parseInt(matrix[Integer.parseInt(op1.substring(2)) - 1][(int)op1.charAt(1)-65]);
                            }

                            if (op2.matches("-?\\d+(\\.\\d+)?")) {
                                num2 = Integer.parseInt(op2);
                            } else {
                                num2 = Integer.parseInt(matrix[Integer.parseInt(op2.substring(1))-1][(int)op2.charAt(0)-65]);
                            }
                            matrix[i][j] = String.valueOf(num1 - num2);
                        } else{
                            matrix[i][j] = String.valueOf(Integer.parseInt(matrix[Integer.parseInt(matrix[i][j].substring(2)) - 1][(int)matrix[i][j].charAt(1)-65]));
                        }
                    }
                }
            }

            //输出表达式解析
            String[] output = in.nextLine().split(":");

            int res = 0;
            for (int i=Integer.parseInt(output[0].substring(1))-1;i<Integer.parseInt(output[1].substring(1));i++) {
                for (int j=(int)output[0].charAt(0)-65;j<(int)output[1].charAt(0)-65+1;j++) {
                    res += Integer.parseInt(matrix[i][j]);
                }
            }

            System.out.print(res);

        }

    }
}
