import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check if current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If valid strings are found at this level,
            // don't generate strings with more removals.
            if (found) {
                continue;
            }

            // Remove one parenthesis at every position
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // Only remove parentheses
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = current.substring(0, i)
                        + current.substring(i + 1);

                // Avoid duplicate strings
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return result;
    }


    // Checks whether the parentheses are valid
    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }

            else if (ch == ')') {

                count--;

                // More closing brackets than opening brackets
                if (count < 0) {
                    return false;
                }
            }
        }

        // All opening brackets must be closed
        return count == 0;
    }
}