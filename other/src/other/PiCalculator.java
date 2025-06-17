package other;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 使用楚德诺夫斯基公式计算π的指定精度
 */
public class PiCalculator {
    /**
     * 使用楚德诺夫斯基公式计算π到指定的小数位数
     * @param digits 要计算的小数位数
     * @return 计算得到的π值
     */
    public static BigDecimal calculatePi(int digits) {
        // 设置精度（额外增加10位确保精度）
        MathContext mc = new MathContext(digits + 10, RoundingMode.HALF_UP);

        // 常数定义
        final BigInteger A = BigInteger.valueOf(13591409);
        final BigInteger B = BigInteger.valueOf(545140134);
        final BigInteger C3 = BigInteger.valueOf(640320).pow(3); // 640320^3

        // 1. 计算级数 S = Σ(t(k))
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal currentTerm = BigDecimal.ONE; // t(0)初始值

        // 迭代次数估算 (每项约增加14位精度)
        int iterations = (int) (digits / 14.18) + 3;

        // 首项计算 (k=0)
        currentTerm = new BigDecimal(A).multiply(BigDecimal.ONE, mc); // (13591409)
        sum = sum.add(currentTerm, mc);

        // 迭代计算 k=1 到 iterations-1
        for (int k = 1; k < iterations; k++) {
            // 递推计算下一项 t(k) = t(k-1) * [ -1 * (6k-5)(6k-4)...(6k) * (A+Bk) ]
            //                     / [ (3k-2)(3k-1)(3k) * k^3 * 640320^3 * (A+B(k-1)) ]

            // 分子部分: -1 * (6k-5)到(6k)的乘积 * (A+Bk)
            BigDecimal numerator = BigDecimal.ONE;
            for (int i = 1; i <= 6; i++) {
                numerator = numerator.multiply(
                        new BigDecimal(BigInteger.valueOf(6L*k - 6 + i)), mc);
            }
            numerator = numerator.multiply(new BigDecimal(A.add(B.multiply(BigInteger.valueOf(k)))), mc)
                    .negate(); // 乘以-1

            // 分母部分: (3k-2)(3k-1)(3k) * k^3 * 640320^3 * (A+B(k-1))
            BigDecimal denominator = BigDecimal.ONE;
            for (int i = 1; i <= 3; i++) {
                denominator = denominator.multiply(
                        new BigDecimal(BigInteger.valueOf(3L*k - 3 + i)), mc);
            }
            denominator = denominator.multiply(new BigDecimal(BigInteger.valueOf(k).pow(3)), mc)
                    .multiply(new BigDecimal(C3), mc)
                    .multiply(new BigDecimal(A.add(B.multiply(BigInteger.valueOf(k-1)))), mc);

            // 计算系数 = 分子/分母
            BigDecimal factor = numerator.divide(denominator, mc);

            // 更新当前项: t(k) = t(k-1) * factor
            currentTerm = currentTerm.multiply(factor, mc);

            // 累加到总和
            sum = sum.add(currentTerm, mc);
        }

        // 2. 计算 √10005
        BigDecimal sqrt10005 = sqrt(new BigDecimal(10005), mc);

        // 3. 计算最终π值: π = 426880 * √10005 / S
        BigDecimal pi = new BigDecimal("426880").multiply(sqrt10005, mc)
                .divide(sum, mc);

        // 四舍五入到指定精度
        return pi.round(new MathContext(digits, RoundingMode.HALF_UP));
    }
    /**
     * 使用牛顿法计算大数的平方根
     * @param x 要计算平方根的数
     * @param mc 精度上下文
     * @return 平方根结果
     */
    private static BigDecimal sqrt(BigDecimal x, MathContext mc) {
        if (x.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        if (x.signum() < 0) {
            throw new ArithmeticException("负数的平方根");
        }

        // 初始值 = √x 的粗略估计
        BigDecimal current = new BigDecimal(Math.sqrt(x.doubleValue()));
        BigDecimal precision = BigDecimal.ONE.scaleByPowerOfTen(-mc.getPrecision());

        while (true) {
            BigDecimal next = x.divide(current, mc)
                    .add(current)
                    .divide(BigDecimal.valueOf(2), mc);
            // 检查是否达到所需精度
            if (next.subtract(current).abs().compareTo(precision) < 0) {
                return next;
            }
            current = next;
        }
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = calculatePi(10);
        System.out.println("bigDecimal = " + bigDecimal);
    }
}
