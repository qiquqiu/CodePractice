package algorjuniorseries.stack02;

public class Stack02Main {
    public static void main(String[] args) {
        Stack02Solution s02s = new Stack02Solution();
        int[] pushV = {1, 2, 3, 4, 5};
        int[] popV = {1, 3, 2, 5, 4};
        s02s.IsPopOrder(pushV, popV);
    }
}