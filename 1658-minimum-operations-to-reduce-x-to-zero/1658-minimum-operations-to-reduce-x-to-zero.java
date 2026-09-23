class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        // If target == 0, remove everything
        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // Shrink window
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            // Found target sum
            if (sum == target) {
                maxLen = Math.max(
                    maxLen,
                    right - left + 1
                );
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}