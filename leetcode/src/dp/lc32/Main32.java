package dp.lc32;

public class Main32 {
    public static void main(String[] args) {
//        Solution32_harder s32 = new Solution32_harder();
//        int maxMatchedLength = s32.longestValidParentheses("[}]()([{}]");
//        System.out.println(maxMatchedLength);

        Solution32_stack s32 = new Solution32_stack();
        int maxMatchedLength = s32.longestValidParentheses("())((())");
        System.out.println(maxMatchedLength);
    }
}
