
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long sumL = 0, sumR = 0;
    int sizeL = 0, sizeR = 0;

    void addToMap(TreeMap<Integer, Integer> map, int val) {
        map.merge(val, 1, Integer::sum);
    }

    void removeFromMap(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    void add(int num) {

        if (left.isEmpty() || num <= left.lastKey()) {
            addToMap(left, num);
            sumL += num;
            sizeL++;
        } else {
            addToMap(right, num);
            sumR += num;
            sizeR++;
        }

        balance();
    }

    void remove(int num) {

        if (left.containsKey(num)) {
            removeFromMap(left, num);
            sumL -= num;
            sizeL--;
        } else {
            removeFromMap(right, num);
            sumR -= num;
            sizeR--;
        }

        balance();
    }

    void balance() {

        int target = (sizeL + sizeR + 1) / 2;

        while (sizeL > target) {

            int val = left.lastKey();

            removeFromMap(left, val);
            sumL -= val;
            sizeL--;

            addToMap(right, val);
            sumR += val;
            sizeR++;
        }

        while (sizeL < target) {

            int val = right.firstKey();

            removeFromMap(right, val);
            sumR -= val;
            sizeR--;

            addToMap(left, val);
            sumL += val;
            sizeL++;
        }
    }

    long getCost() {

        long median = left.lastKey();

        return median * sizeL - sumL
                + sumR - median * sizeR;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        // Sliding window
        for (int i = 0; i < n; i++) {

            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        // DP
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select window ending at i - 1
                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
