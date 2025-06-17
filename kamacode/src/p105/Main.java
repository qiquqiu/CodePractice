package p105;

import java.util.*;

/**
 * https://kamacoder.com/problempage.php?pid=1177
 */
public class Main {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 使用临界表存储有向图，跟无向图思路一样，只不过边不是双向
        // 直接借鉴之前的无向图的邻接表的实现方式，对于该存储方式来说，有向图只不过是无向图的一种特殊情况：无向图的边是两条相互的有向边
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        visited = new boolean[n + 1];

        // 初始化
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 录入边
        for (int i = 0; i < k; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<Integer> list = graph.get(start);
            list.add(end);
        }

        // 遍历检查从1号起，是否能到所有顶点（dfs检查）
        dfs(graph, 1);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

    // 做完一些专门的集合深搜题，再看图论的标准dfs还是很显然的（从图论这里也可以看出其实模板是一样的）
    public static void dfs(HashMap<Integer, List<Integer>> g, int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        List<Integer> list = g.get(start);
        for (int i = 0; i < list.size(); i++) {
            // 遍历当前点的所有边
            dfs(g, list.get(i));
        }
    }
}
