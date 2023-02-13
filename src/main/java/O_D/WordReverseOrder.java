package O_D;

/**
 * 单词倒序
 * 输入单行英文句子，里面包含英文字母，空格以及.? 三种标点符号，请将句子内每个单词进行倒序，并输出倒序后的语句
 * 输入描述:
 * 输入字符串S，S的长度1≤N≤100
 * 输出描述:
 * 输出逆序后的字符串
 * 补充说明:
 * 标点符号左右的空格>=0，单词间空格 >0
 *
 * 示例1
 * 输入:
 * yM eman si boB.
 * 输出:
 * My name is Bob.
 * 示例2
 * 输入:
 * woh era uoy ? I ma enif.
 * 输出:
 * how are you ? I am fine.
 */
import java.util.Scanner;
public class WordReverseOrder {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();

            String res = "";
            String temp = "";
            for(int i=0; i<input_str.length(); i++){
                char c = input_str.charAt(i);
                //是否为字母
                if(Character.isLetter(c)){
                    temp += c;
                    //遇到空格，对上一个字符串进行翻转
                }else if(c == ' '){
                    res += reverse(temp) + " ";
                    temp = "";
                    // 遇到标点符号，对上一个字符串进行翻转，并加上当前字符
                }else {
                    if(temp !=  ""){
                        res += reverse(temp);
                        temp = "";
                    }
                    res += c;
                }
                if(i == input_str.length()-1 && temp != ""){
                    res += reverse(temp);
                }
            }

            System.out.println(res);
        }

        public static String reverse(String str){
            String res =  "";
            for(int i = str.length()-1; i>=0; i--){
                res += str.charAt(i);
            }

            return res;
        }
    }
}
