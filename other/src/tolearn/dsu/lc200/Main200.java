package tolearn.dsu.lc200;

public class Main200 {
    public static void main(String[] args) {
//        Solution200 lsc = new Solution200();

        Solution200_Dsu lsc = new Solution200_Dsu();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int islandCnt = lsc.numIslands(grid);
        System.out.println("islandCnt = " + islandCnt);
    }
}
