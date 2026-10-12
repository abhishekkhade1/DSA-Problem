
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[31];
        int mod = 1_000_000_007;

        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }

        long sum = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 0; j < 31; j++) {
                if (bits[j] > 0) {
                    num |= (1L << j);
                    bits[j]--;
                }
            }

            sum = (sum + num * num) % mod;
        }

        return (int) sum;
    }
}
