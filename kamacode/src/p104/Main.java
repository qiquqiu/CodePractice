package p104;

import java.util.*;

/**
 * 构造最大岛屿 https://kamacoder.com/problempage.php?pid=1176
 * AC
 * 其实map的值没必要用Set<String>来存具体的陆地集，只要有数量即可
 * 另外maxVal需要初始化，如果有陆地初始化未第一个陆地，没有初始化为0，Line51 必须判断，否则为0会get到null空指针
 * 另外，向四个方向遍历的时候的逻辑需要使用哈希表去重，防止其实某些方向本来就是一块陆地结果导致多遍相加出错
 * https://www.programmercarl.com/kamacoder/0104.%E5%BB%BA%E9%80%A0%E6%9C%80%E5%A4%A7%E5%B2%9B%E5%B1%BF.html#%E4%BC%98%E5%8C%96%E6%80%9D%E8%B7%AF
 */
public class Main {
    static int n, m, size;
    static int[][] visited;
    // 唯一巧妙的点，利用非0非1的不同编号做map的键，既可以支持后续快速获取又可以结合visited数组轻松判断（与karl网站思路一致）
    static int islandCnt = 2;

    public static void main(String[] args) {
        // 思路，先dfs搜索出所有的岛屿信息
        // 所谓的信息，就是岛屿的编号以及构成岛屿的陆地坐标
        // 可以使用Map<Integer, Integer>
        // 然后遍历每个水，依次找该水上下左右的陆地，然后遍历岛屿集合，找指定的陆地是否在某个集合（岛屿）之中，在则更新maxVal
        // 四个方位都要依次遍历

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] area = new int[n][m];
        // 单独弄一个visited数组而非直接操作原地图以水作访问过标记因为后续还要用
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        // 搜索出所有岛屿
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 1 && visited[i][j] == 0) {
                    size = 0;
                    dfs(area, i, j);
                    map.put(islandCnt++, size);
                }
            }
        }

        // 遍历所有水，找最大结果;岛屿编号从2开始，visited数组中数字是几就代表几号岛屿
        int maxVal = map.get(2) == null ? 0 : map.get(2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) {
                    Set<Integer> adjacentIslands = new HashSet<>();
                    // 检查水四个方向的土地，检查完之后一并更新maxVal

                    if (i - 1 >= 0 && visited[i - 1][j] >= 2) {
                        adjacentIslands.add(visited[i - 1][j]);
                    }
                    if (i + 1 < n && visited[i + 1][j] >= 2) {
                        adjacentIslands.add(visited[i + 1][j]);
                    }
                    if (j - 1 >= 0 && visited[i][j - 1] >= 2) {
                        adjacentIslands.add(visited[i][j - 1]);
                    }
                    if (j + 1 < m && visited[i][j + 1] >= 2) {
                        adjacentIslands.add(visited[i][j + 1]);
                    }
                    // 计算合并后的总面积
                    int total = 1; // 当前水域变为陆地
                    for (int islandId : adjacentIslands) {
                        total += map.get(islandId);
                    }

                    maxVal = Math.max(maxVal, total);
                }
            }
        }
        System.out.println(maxVal);
    }

    public static void dfs(int[][] area, int i, int j) {
        // 进入时统一判断不符条件;没访问过要么是0，要么是1
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] >= 2 || area[i][j] == 0) {
            return;
        }

        // 没访问过且是陆地
        visited[i][j] = islandCnt;
        size++;

        dfs(area, i - 1, j);
        dfs(area, i + 1, j);
        dfs(area, i, j - 1);
        dfs(area, i, j + 1);
    }
}
