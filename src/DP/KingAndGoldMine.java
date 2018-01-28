package DP;

/**
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * Created by woo23 on 2017/12/10.
 *
 * 对于一个矿我们可以选择挖或者不挖 如果挖了人力减少山也减少，如果不挖人力不减少 山减少
 * 所有将所有的山遍历一遍就可以找到最终的结果了
 * 最终的结果就是 要么山没有了 要么人没有了
 */
public class KingAndGoldMine {
    public int solution(int[][] GoldPerson, int person){


        return helper(GoldPerson, person, 0, 0);
    }

    public int helper(int[][] GoldMoutain,  int person, int gold, int index) {
        if (index >= GoldMoutain.length)
            return gold;

        if (GoldMoutain[index][1] > person)
            return gold;
        else
            return Math.max(helper(GoldMoutain, person - GoldMoutain[index][0], gold + GoldMoutain[index][1], index + 1),
                    helper(GoldMoutain, person, gold, index + 1));

    }
}
