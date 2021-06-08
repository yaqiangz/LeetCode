package other;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class O21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        int l = 0, r = len - 1;
        while (l < r) {
            if (nums[l] % 2 == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                l++;
            }
        }
        return nums;
    }
}
