package hashtable.lc202;

public class Main202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        boolean isHappy = solution202.isHappy(19);
        System.out.println(isHappy ? "是快乐数" : "不是快乐数");

        System.out.println("--------------------------------------");
        Solution202_2 solution202_2 = new Solution202_2();
//        System.out.println(solution202_2.getNext(1));
        boolean isHappy2 = solution202_2.isHappy(82);
        System.out.println(isHappy2 ? "是快乐数" : "不是快乐数");
    }
}
