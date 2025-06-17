package unclassified.lc54;

import java.util.List;

public class Main54 {
    public static void main(String[] args) {
        Solution54 s54 = new Solution54();

//        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        List<Integer> list1 = s54.spiralOrder(matrix1);
//        System.out.println("list1 = " + list1);
//
//        int[][] matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        List<Integer> list2 = s54.spiralOrder(matrix2);
//        System.out.println("list2 = " + list2);


        int[][] matrix3 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}};
        List<Integer> list3 = s54.spiralOrder(matrix3);
        System.out.println("list3 = " + list3);
    }
}
