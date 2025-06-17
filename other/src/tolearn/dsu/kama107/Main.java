package tolearn.dsu.kama107;

import tolearn.dsu.DisjointSetUnion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://kamacoder.com/problempage.php?pid=1179
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s+");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        DisjointSetUnion<Integer> dsu = new DisjointSetUnion<>();
        for (int i = 1; i <= n; i++) {
            dsu.add(i);
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split("\\s");
            dsu.join(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        split = br.readLine().split("\\s");
        System.out.println(
                dsu.isConnected(Integer.parseInt(split[0]), Integer.parseInt(split[1]))
                ? 1 : 0);
    }
}
