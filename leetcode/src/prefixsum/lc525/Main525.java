package prefixsum.lc525;

public class Main525 {
    public static void main(String[] args) {
        Solution525 s525 = new Solution525();
        int[] arr = new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0};
        int maxLength = s525.findMaxLength(arr);
        System.out.println("maxLength = " + maxLength);
    }
}
