class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();

        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Save current string
                stack.push(curr);

                // Start a new substring
                curr = new StringBuilder();

            } else if (ch == ')') {

                // Reverse current substring
                curr.reverse();

                // Add it to previous level
                StringBuilder prev = stack.pop();

                prev.append(curr);

                curr = prev;

            } else {

                curr.append(ch);
            }
        }

        return curr.toString();
    }
}