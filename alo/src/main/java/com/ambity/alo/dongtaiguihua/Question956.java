package com.ambity.alo.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
 *
 * 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
 *
 * 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
 * 示例 1：
 * 输入：[1,2,3,6]
 * 输出：6
 * 解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：10
 * 解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。
 */
public class Question956 {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dict = new HashMap<>();
        Map<Integer, Integer> copy = new HashMap<>();
        dict.put(0, 0);
        for (int i : rods) {
            copy.clear();
            copy.putAll(dict);
            for (Integer key : copy.keySet()) {
                dict.put(key + i, Math.max(dict.getOrDefault(key + i, 0),
                        copy.get(key) + i));
                dict.put(key - i, Math.max(dict.getOrDefault(key - i, 0),
                        copy.get(key)));
            }
        }
        return dict.get(0);
    }
}
