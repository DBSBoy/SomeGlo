package algorithm.O2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 热点网站统计
 */
public class HotNet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        StringBuffer result = new StringBuffer();

        while(in.hasNext()){
            String input_str = in.nextLine();
            //用抛异常的方式判断此行是否为int
            try {
                int num = Integer.parseInt(input_str);
                List<String> list = new ArrayList<>();
                map.forEach((k,v)->{
                    list.add(v+" "+k);
                });
                //自定义排序方法
                list.sort((o1,o2)->{
                    int value1 = Integer.parseInt(o1.split(" ")[0]);
                    int value2 = Integer.parseInt(o2.split(" ")[0]);
                    if(value1 == value2){
                        String key1 = o1.split(" ")[1];
                        String key2 = o2.split(" ")[1];
                        return key1.compareTo(key2);
                    }else{
                        return value2 - value1;
                    }
                });
                for(int i=0;i<num;i++){
                    result.append(list.get(i).split(" ")[1]).append(",");
                }
                result.delete(result.length()-1,result.length()).append("\n");
            }catch (Exception e){
                if(map.containsKey(input_str)){
                    int value = map.get(input_str);
                    map.put(input_str,value+1);
                }else{
                    map.put(input_str,1);
                }
            }
        }
        System.out.println(result);
    }

}
