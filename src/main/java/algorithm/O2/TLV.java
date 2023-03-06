package algorithm.O2;

import java.util.Scanner;

/**
 * TLVTLV
 */
public class TLV {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        String tag = in.nextLine();
        String[] tlv_info = in.nextLine().split(" ");
        for (int i = 0; i < tlv_info.length; ) {
            //转成int
            int length = Integer.parseInt(tlv_info[i + 2] + tlv_info[i + 1], 16);
            if (tag.equals(tlv_info[i])) {
                StringBuilder res_str = new StringBuilder();
                for (int j = i + 3; j < i + 3 + length; j++) {
                    res_str.append(tlv_info[j]).append(" ");
                }
                System.out.println(res_str.toString());
                break;
            } else {
                i += length + 3;
            }
        }
    }
}
