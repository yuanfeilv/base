package com.ambity.alo.offer;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 实际上就是排序，先根据最高位排序，如果相同，则按下一位排，
 * 如果还是相同直到一个数字用尽还是相同，则比较剩余的数组的首字母与当前字母的大小，采用快速排序提高效率
 * 排序判断规则： 设 numsnums 任意两数字的字符串格式 xx 和 yy ，则
 * 若拼接字符串 x + y > y + xx+y>y+x ，则 m > nm>n ；
 * 反之，若 x + y < y + xx+y<y+x ，则 n < mn<m ；
 *
 */
public class Question45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
    void fastSort(String[] strs, int l, int r) {
        if(l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }


    public static void main(String[] args) {
        Question45 question45 = new Question45();
        int[] num = {121,12};
        System.out.println(question45.minNumber(num));
    }
}
