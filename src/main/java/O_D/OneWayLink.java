package O_D;


import java.util.Scanner;
import java.util.*;

/**
 * 单向链表
 */
class OneWayLink {
    // 节点定义
    public static class ListNode {
        public int value;
        public int next;

        public ListNode(int value, int next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String head_node_str = in.nextLine();
        String[] head_info = head_node_str.split(" ");
        int head_addr = Integer.valueOf(head_info[0]);
        int count = Integer.valueOf(head_info[1]);

        HashMap<Integer, ListNode> node_info = new HashMap<Integer, ListNode>();
        for (int i = 0; i < count; i++) {
            String node_str = in.nextLine();
            String[] node_list_info = node_str.split(" ");
            int addr = Integer.parseInt(node_list_info[0]);
            int val = Integer.parseInt(node_list_info[1]);
            int next = Integer.parseInt(node_list_info[2]);
            ListNode temp_node = new ListNode(val, next);
            node_info.put(addr, temp_node);
        }

        // 构造链表，剔除无效节点
        int size = 1, cur = 0;
        ListNode head = node_info.get(head_addr);
        ListNode thead = head;
        while (thead.next != -1) {
            size++;
            thead = node_info.get(thead.next);
        }


        // 找中间节点
        while (head.next != -1) {
            if ((size / 2) == cur) {
                System.out.println(head.value);

            }
            head = node_info.get(head.next);
            cur++;
        }
    }
}
