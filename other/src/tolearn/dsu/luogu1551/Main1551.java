package tolearn.dsu.luogu1551;

import tolearn.dsu.DisjointSetUnion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 洛谷1551 AC 就是并查集的Demo的题的原型：走亲戚题
 */
public class Main1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int p = Integer.parseInt(split[2]);

        DisjointSetUnion<Integer> dsu = new DisjointSetUnion<>();

        for (int i = 1; i <= n; i++) {
            dsu.add(i);
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            dsu.join(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        for (int i = 0; i < p; i++) {
            split = br.readLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);

            System.out.println(dsu.isConnected(v1, v2) ? "Yes" : "No");
        }
    }
}
