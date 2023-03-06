package od2;

import java.util.*;

/**
 * yi硬件资源
 */
public class hardwareResources {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());
        int[][] server_matrix = new int[M][5];
        for (int i = 0; i < M; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < 5; j++) {
                server_matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = in.nextInt();
        int strategy = in.nextInt();
        int cpuCount = in.nextInt();
        int memSize = in.nextInt();
        int cpuArch = in.nextInt();
        int supportNP = in.nextInt();

        //筛选符合条件的服务器
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if (server_matrix[i][1] >= cpuCount && server_matrix[i][2] >= memSize
                    && (server_matrix[i][3] == cpuArch || cpuArch == 9)
                    && (server_matrix[i][4] == supportNP || supportNP == 2)) {
                map.put(server_matrix[i][0], Arrays.copyOfRange(server_matrix[i], 1, server_matrix[i].length));
            }
        }
        List<Map.Entry<Integer, int[]>> list = new ArrayList<Map.Entry<Integer, int[]>>(map.entrySet());
        // 如果策略1，先CPU核数，再内存，再编号
        if (strategy == 1) {
            list.sort((server1, server2) -> (server1.getValue()[0] == server2.getValue()[0] ? (server1.getValue()[1] == server2.getValue()[1] ?
                    server1.getKey() - server2.getKey() : server1.getValue()[1] - server2.getValue()[1]) :  server1.getValue()[0] - server2.getValue()[0]));
        }
        // 如果策略2，先内存，再CPU核数，再编号
        if (strategy == 2) {
            list.sort((server1, server2) -> (server1.getValue()[1] == server2.getValue()[1] ? (server1.getValue()[0] == server2.getValue()[0] ?
                    server1.getKey() - server2.getKey() : server1.getValue()[0] - server2.getValue()[0]) :  server1.getValue()[1] - server2.getValue()[1]));
        }
        int resCount = Math.min(map.size(), N);
        int[] res = new int[resCount];

        for (int i = 0; i < resCount; i++) {
            Map.Entry<Integer, int[]> entry = list.get(i);
            res[i] = entry.getKey();
        }
        Arrays.sort(res);
        System.out.print(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.print(" " + res[i]);
        }
    }
}
