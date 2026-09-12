class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
         int n = intervals.size();

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> 
            Integer.compare(intervals.get(a).get(0), intervals.get(b).get(0)));

        int[] lArr = new int[n], rArr = new int[n], origIdx = new int[n];
        long[] wArr = new long[n];
        for (int i = 0; i < n; i++) {
            int oi = order[i];
            List<Integer> iv = intervals.get(oi);
            lArr[i] = iv.get(0);
            rArr[i] = iv.get(1);
            wArr[i] = iv.get(2);
            origIdx[i] = oi;
        }

        // first position j such that lArr[j] > rArr[i] (shared endpoint = overlap)
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) nextIdx[i] = upperBound(lArr, rArr[i]);

        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++) dp[n][k] = new State(0L, new int[0]);
        for (int i = 0; i <= n; i++) dp[i][0] = new State(0L, new int[0]);

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];

                State subTake = dp[nextIdx[i]][k - 1];
                long takeScore = wArr[i] + subTake.score;
                int[] takeIdx = new int[subTake.idx.length + 1];
                System.arraycopy(subTake.idx, 0, takeIdx, 0, subTake.idx.length);
                takeIdx[takeIdx.length - 1] = origIdx[i];
                Arrays.sort(takeIdx);
                State take = new State(takeScore, takeIdx);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].idx;
    }

    // higher score wins; tie -> lexicographically smaller index array wins
    private State better(State a, State b) {
        if (a.score != b.score) return a.score > b.score ? a : b;
        int len = Math.min(a.idx.length, b.idx.length);
        for (int i = 0; i < len; i++) {
            if (a.idx[i] != b.idx[i]) return a.idx[i] < b.idx[i] ? a : b;
        }
        return a.idx.length <= b.idx.length ? a : b;
    }

    private int upperBound(int[] arr, int x) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] > x) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    static class State {
        long score;
        int[] idx;
        State(long score, int[] idx) {
            this.score = score;
            this.idx = idx;
        }
        
    }
}