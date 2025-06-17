package lq_13_java_b;

import java.math.BigInteger;

public class Main1 {
    public static void main(String[] args) {
        BigInteger val1 = new BigInteger("20");
        BigInteger powed = val1.pow(22);
        BigInteger modded = powed.mod(new BigInteger("7"));
        System.out.println(modded);
    }
}
