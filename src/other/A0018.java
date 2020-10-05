package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 注意：
 答案中不可以包含重复的四元组。
 示例：
 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class A0018 {
    public static void main(String[] args) {
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        System.out.println(fourSum(nums, -7));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i+3 < len; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)
                return res;
            for (int j = i + 1; j + 2 < len; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target)
                    break;
                if (nums[i] + nums[j] + nums[len-1] + nums[len-2] < target)
                    continue;
                int l = j + 1, r = len - 1;
                while (l < r) {
                    while (l > j + 1 && nums[l] == nums[l-1]) l++;
                    while (r < len - 1 && nums[r] == nums[r+1]) r--;
                    if (l >= r)
                        break;
                    int val = nums[i] + nums[j] + nums[l] + nums[r];
                    if (val == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (val > target) {
                        r--;
                    } else {
                        l++;
                    }
                }

            }
        }
        return res;
    }
}
