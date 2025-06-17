package algorjuniorseries.stack03;

public class Stack03Main {
    public static void main(String[] args) {
        Stack03Solution s03 = new Stack03Solution();
        boolean valid = s03.isValid("[()[[]()]]");
        System.out.println(valid);
    }
}
// (({}))  true
// ()[[]]{} true