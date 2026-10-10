import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        // We can make all differences zero.
        if (total <= k) {
            return 0;
        }

        // Binary search for the minimum possible maximum difference.
        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;
        long remaining = k;
        long answer = 0;

        // Reduce every difference greater than limit.
        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            answer += (long) d * d;
        }

        // Use remaining operations to reduce differences at the limit.
        // Each reduction from limit to limit - 1 saves 2*limit - 1.
        long count = Math.min(remaining, n);
        answer -= count * (2L * limit - 1);

        return answer;
    }
}