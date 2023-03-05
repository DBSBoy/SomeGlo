package algorithm.O2;

/**
 * 城市聚集度
 */
import java.util.Scanner;
import java.util.*;
public class CityCollect {
    public static class Main {
        //并查集模板
        static class UnionFind {
            int N;
            int count;
            int[] id;
            int[] sz;

            private UnionFind (int n) {
                N = n;
                count = n;
                id = new int[n + 1];
                sz = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    id[i] = i;
                    sz[i] = 1;
                }
            }

            public int getMax () {
                int max = 0;
                for (int i = 1; i < sz.length; i++) {
                    max = Math.max(max, sz[i]);
                }
                return max;
            }

            public void union (int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot != qRoot) {
                    if (sz[pRoot] < sz[qRoot]) {
                        id[pRoot] = qRoot;
                        sz[qRoot] += sz[pRoot];
                    } else {
                        id[qRoot] = pRoot;
                        sz[pRoot] += sz[qRoot];
                    }
                    count--;
                }
            }

            private int find (int p) {
                if (p == id[p]) {
                    return p;
                }
                id[p] = find(id[p]);
                return id[p];
            }
        }

        public static void main(String[] args) {
            //处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n - 1; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }

            int res = Integer.MAX_VALUE;
            int[] maxArray = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                UnionFind uf = new UnionFind(n);
                for (int j = 0; j < n - 1; j++) {
                    if (arr[j][0] == i || arr[j][1] == i)  {
                        continue;
                    } else {
                        uf.union(arr[j][0], arr[j][1]);
                    }
                }
                maxArray[i] = uf.getMax();
                res = Math.min(res, maxArray[i]);
            }
            String result = "";
            for (int i = 1; i < maxArray.length; i++) {
                if (maxArray[i] == res) {
                    result += String.valueOf(i) + " ";
                }
            }
            System.out.println(result);
        }
    }

}
