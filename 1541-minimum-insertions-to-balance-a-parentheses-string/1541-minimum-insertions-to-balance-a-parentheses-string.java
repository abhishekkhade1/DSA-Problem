class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                // Ensure two consecutive closing parentheses
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }

                // No opening parenthesis available
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }

            i++;
        }

        return ans + 2 * open;
    }
}