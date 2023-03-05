package algorithm.O2;

/**
 * 高矮个子排队
 */
import java.util.*;
import java.util.stream.Collectors;
public class TallAndShort {
    static class Main {
        public static void main(String[] args) {
            // 输入处理
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            for(int i=0;i<s.length();i++){
                if (s.charAt(i)==' ') {
                    continue;
                }
                if (s.charAt(i)>='0' && s.charAt(i)<='9') {
                    continue;
                }
                // 输入异常
                System.out.println("[]");
                return;
            }

            //转为数组
            List<Integer> nums =Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            //比较
            for(int i=0;i<nums.size()-1;i++){
                if(i%2==0){
                    if(nums.get(i)<nums.get(i+1)){
                        int tmp = nums.get(i);
                        nums.set(i, nums.get(i+1));
                        nums.set(i+1, tmp);
                    }
                } else{
                    if(nums.get(i)>nums.get(i+1)){
                        int tmp = nums.get(i);
                        nums.set(i, nums.get(i+1));
                        nums.set(i+1, tmp);
                    }
                }
            }
            for(int i=0;i<nums.size();i++){
                System.out.print(nums.get(i)+" ");
            }

        }
    }
}
