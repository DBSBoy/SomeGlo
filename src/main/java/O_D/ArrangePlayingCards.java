package O_D;

/**
 * 整理扑克牌
 * 给定一组数字，表示扑克牌的牌面数字，忽略扑克牌的花色，请按如下规则对这一组扑克牌进行整理:
 *
 * 步骤1、对扑克牌进行分组，形成组合牌，规则如下:当牌面数字相同张数大于等于4时，组合牌为“炸弹”:3张相同牌面数字 + 2张相同牌面数字，且3张牌与2张牌不相同时，组合牌为“葫芦”
 * 3张相同牌面数字，组合牌为“三张”
 * 2张相同牌面数字，组合牌为“对子”
 * 剩余没有相同的牌，则为“单张”:
 * 步骤2、对上述组合牌进行由大到小排列，规则如下:不同类型组合牌之间由大到小排列规则:“炸弹” >"葫芦”>"三张”>"对子”> “单张”:相同类型组合牌之间，除“葫芦”外，按组合牌全部牌面数字加总由大到小排列:"葫芦”则先按3张相同牌面数字加总由大到小排列，3张相同牌面数字加总相同时，再按另外2张牌面数字加总由大到小排列;
 * 由于“葫芦”>“三张”，因此如果能形成更大的组合牌，也可以将“三张”拆分为2张和1张，其中的2张可以和其它“三张”重新组合成“葫芦”，剩下的1张为“单张”
 *
 * 步骤3、当存在多个可能组合方案时，按如下规则排序取最大的一个组合方案:依次对组合方案中的组合牌进行大小比较，规则同上:当组合方案A中的第n个组合牌大于组合方案B中的第n个组合牌时，组合方案A大于组合方案B;
 * 输入描述:
 * 第一行为空格分隔的N个正整数，每个整数取值范围[1,13]，N的取值范围[1,1000]
 *
 * 输出描述:
 * 经重新排列后的扑克牌数字列表，每个数字以空格分隔
 *
 * 示例1
 * 输入:
 * 1 3 3 3 2 1 5
 * 输出:
 * 3 3 3 1 1 5 2
 * 示例2
 * 输入:
 * 4 4 2 1 2 1 3 3 3 4
 * 输出:
 * 4 4 4 3 3 2 2 1 1 3
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
public class ArrangePlayingCards {
    static class Main {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            List<Integer> nums =Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            //key为牌面点数，value为该点数的张数
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // 排序，先按张数排序，再按点数排序
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a,b) -> {
                if(b.getValue() == a.getValue()){
                    return b.getKey() - a.getKey();
                }
                return b.getValue() - a.getValue();
            });

            // 特殊情况处理
            StringBuffer sb = new StringBuffer();
            List<Integer> split_cards = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                Map.Entry<Integer, Integer> temp = list.get(i);
                int carNum = temp.getKey();
                int carCount = temp.getValue();
                // 3+3的情况，要拆分成葫芦
                if(i > 0 && list.get(i-1).getValue() == 3 && carCount == 3){
                    split_cards.add(carNum);
                    carCount = 2;
                    temp.setValue(2);
                    // 给拆分的牌也组合一下
                }else if(carCount == 1 && split_cards.size() != 0){
                    for (int k=0; k<split_cards.size(); k++){
                        // 当拆分中的牌大于此牌时，先安排拆分的牌
                        if(split_cards.get(k) > carNum){
                            sb.append(split_cards.get(k) + " ");
                            split_cards.remove(k);
                            k--;
                        }
                    }
                }
                for(int j=0; j<carCount; j++){
                    sb.append(carNum + " ");
                }
            }

            if(split_cards.size() != 0){
                for(int i : split_cards){
                    sb.append(i + " ");
                }
            }

            System.out.println(sb.substring(0, sb.length()-1));
        }

    }
}
