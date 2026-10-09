class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                ans[i] = i % 2;
            } else {
                ans[i] = 1 - (i % 2);
            }
        }

        return ans;
    }
}