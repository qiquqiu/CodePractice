package greedy.lc53;

public class Main53 {
    // {-2, -1}
    static int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public static void main(String[] args) {
        int max = new Solution53().maxSubArrayGreedy(arr);
        System.out.println("max = " + max);
    }
}
