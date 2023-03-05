package O_D;

/**
 * 猜字谜
 * 小干设计了一人简单的清字谈游戏，游戏的迷面是一人错误的单词，比如nwes，玩家需要猜出谈底库中正确的单词。猜中的要求如·
 * 对于某个谜面和谜底单词，满足下面任一条件都表示猜中:
 * 1)变换顺序以后一样的，比如通过变换w和e的顺序，“nwes”跟“news”是可以完全对应的
 * 2)字母去重以后是一样的，比如“woood”和“wood”是一样的，它们去重后都是“wod”请你写一个程序帮忙在谜底库中找到正确的谜底。迷面是多个单词，都需要找到对应的谜底，如果找不到的话，返"not found"
 *
 * 输入描述
 * 1、谜面单词列表，以","分隔
 * 2、谜底库单词列表，以","分隔
 * 输出描述:
 * 匹配到的正确单词列表，以“,”分隔如果找不到，返回"not found"
 * 补充说明:
 * 1、单词的数量N的范围: 0 < N < 1000
 * 2、词汇表的数量M的范围: 0 < M< 1000
 * 3、单词的长度P的范围: 0< P< 203
 * 4、输入的字符只有小写英文字母，没有其它字符
 *
 * 示例1
 * 输入:
 * conection
 * connection,today
 * 输出:
 * connection
 */
import java.util.Scanner;
import java.util.*;
public class DoAWordPuzzle {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String[] problems = in.nextLine().split(",");
            String[] answers = in.nextLine().split(",");

            List<String> resList = new ArrayList<>();
            for(int i=0; i<problems.length; i++){
                String problem = problems[i];
                boolean flag = false;
                for(int j=0; j<answers.length; j++){
                    String answer = answers[j];
                    // 变换顺序 + 去重对比
                    if(change_order_compare(problem, answer)){
                        resList.add(answer);
                        flag = true;
                    }else if(duplicate_compare(problem, answer)){
                        resList.add(answer);
                        flag = true;
                    }
                }
                if(!flag){
                    resList.add("not found");
                }
            }

            String res = "";
            for(int i=0;i<resList.size();i++){
                res += resList.get(i) + ",";
            }
            System.out.println(res.substring(0,res.length()-1));
        }

        public static boolean change_order_compare(String problem, String answer){

            String[] problem_str = problem.split("");
            Arrays.sort(problem_str);
            String[] answerStrs = answer.split("");
            Arrays.sort(answerStrs);

            if(Arrays.equals(problem_str, answerStrs)){
                return true;
            }

            return false;
        }

        public static boolean duplicate_compare(String problem, String answer){

            List<Character> problem_list = new ArrayList<>();
            for(int i=0; i<problem.length(); i++){
                char c = problem.charAt(i);
                if(!problem_list.contains(c)){
                    problem_list.add(c);
                }
            }

            List<Character> answerList = new ArrayList<>();
            for(int i=0; i<answer.length(); i++){
                char c = answer.charAt(i);
                if(!answerList.contains(c)){
                    answerList.add(c);
                }
            }

            if(problem_list.equals(answerList)){
                return true;
            }
            return false;

        }

    }
}
