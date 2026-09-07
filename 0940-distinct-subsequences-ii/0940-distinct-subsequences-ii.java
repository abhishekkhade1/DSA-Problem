class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;

        int total = 0;
        int[] last = new int[26];

        for(char ch:s.toCharArray()){

            int idx = ch -'a';

            int oldTotal = total;

            int newSubSequence = (oldTotal + 1 - last[idx] + mod) % mod;

            total = (total + newSubSequence) % mod;

            last[idx] = (last[idx] + newSubSequence) % mod;
        }
        return total;
    }
}