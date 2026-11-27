class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        if(s.length() == 0) return 0;

        int right = 0;
        int left = 0;
        int n = s.length();
        int max = 1;

        while(right < n){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, right-left+1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}