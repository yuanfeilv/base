package com.ambity.alo.dongtaiguihua;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 1 1 -3 2
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *  创建3个dp 数组分别保存 状态为持有，未持非冷冻，未持有冷冻
 */
public class Question309 {
    public int maxProfit(int[] prices) {
        int[] hold = new int[prices.length];
        int[] free = new int[prices.length];
        int[] frezz = new int[prices.length];
        if (prices.length<=1){
            return 0;
        }
        hold[0] = 0 - prices[0];

        for (int i =1;i<prices.length;i++){
            hold[i] = Math.max(hold[i-1],free[i-1]-prices[i]);
            free[i] = Math.max(free[i-1],frezz[i-1]);
            frezz[i] = hold[i-1] + prices[i];
        }
        int max = Math.max(hold[prices.length-1],free[prices.length-1]);
        max = Math.max(max,frezz[prices.length-1]);
        return max;
    }

    public static void main(String[] args) {
        Question309 question309 = new Question309();
        int[] i = {1,2,3,0,2};
        System.out.println(question309.maxProfit(i));
    }
}
