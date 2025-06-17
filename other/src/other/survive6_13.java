package other;

import java.util.LinkedList;
import java.util.Random;

public class survive6_13 {
    static LinkedList<People> list;
    static int curNum;

    public static void main(String[] args) {
        int[] ret = new int[600]; // 记录结果集，索引+1为编号，值为次数
        int simulateTime = 100000;
        for (int i = 0; i < simulateTime; i++) {
            ret[simulation() - 1]++;
        }
        int maxSurvivePossibilityNo = ret[0];
        for (int i = 0; i < 600; i++) {
            if (ret[i] > maxSurvivePossibilityNo) {
                maxSurvivePossibilityNo = ret[i];
            }
        }
        System.out.println(simulateTime + "次模拟的结果下，得出原来编号为" + maxSurvivePossibilityNo +
                "的人存活率最高");
    }

    // 一次模拟，返回值为初始编号，范围为1到600
    public static int simulation() {
        curNum = 600;
        list = new LinkedList<>();

        for (int i = 0; i < curNum; i++) {
            // 初始化编号为1-600的人
            list.add(new People(i + 1));
        }

        // 杀到只剩一人
        int killTime = curNum - 1;
        for (int i = 0; i < killTime; i++) {
            killOne();
        }
        return list.get(0).primeNo;
    }

    // 是根据数组值即编号来杀，而不是根据索引来杀
    public static void killOne() {
        // 获取要杀的编号
        Random rand = new Random();
        int randNum = rand.nextInt(curNum + 1) + 1; // 范围[1, curNum + 1]
        int randOdd;
        if (randNum == curNum + 1) {
            randNum--;
        }
        // randNum范围[1, curNum]
        if (randNum % 2 == 0) {
            if (randNum + 1 <= curNum) {
                randOdd = randNum + 1;
            } else {
                // 说明randNum等于curNum且是偶数
                randOdd = randNum - 1;
            }
        } else {
            randOdd = randNum;
        }

        // 带索引的链表的删除后的逻辑就是后面自动补位上来
        list.remove(randOdd - 1);
        curNum--;
    }
}

class People {
    final int primeNo;
    int curNo; // 当前编号，为在链表中的索引值加1

    public People(int primeNo) {
        this.primeNo = primeNo;
    }
}

