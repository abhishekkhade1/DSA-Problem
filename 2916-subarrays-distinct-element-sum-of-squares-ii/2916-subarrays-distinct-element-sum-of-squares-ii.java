
import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(n);
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            int prev = last.getOrDefault(x, -1);

            seg.update(prev + 1, j, 1);

            ans = (ans + seg.query()) % MOD;
            last.put(x, j);
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum, square, lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            square = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;

            square[node] = (square[node]
                    + 2 * val % MOD * sum[node] % MOD
                    + len % MOD * val % MOD * val % MOD) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void update(int node, int l, int r,
                    int ql, int qr, long val) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, r, ql, qr, val);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            square[node] = (square[node * 2]
                    + square[node * 2 + 1]) % MOD;
        }

        void update(int l, int r, long val) {
            update(1, 0, n - 1, l, r, val);
        }

        long query() {
            return square[1];
        }
    }
}
