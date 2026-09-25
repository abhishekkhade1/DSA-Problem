class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length());
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s, int start, int end) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = start;

        while (i < end) {

            if (s.charAt(i) == '{') {

                int j = findClosingBrace(s, i);

                Set<String> inside = parse(s, i + 1, j);

                // Concatenation
                current = combine(current, inside);

                i = j + 1;

            } else if (s.charAt(i) == ',') {

                // Union
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;

            } else {

                // Normal character
                Set<String> single = new HashSet<>();
                single.add(String.valueOf(s.charAt(i)));

                current = combine(current, single);

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }

    private int findClosingBrace(String s, int open) {
        int balance = 0;

        for (int i = open; i < s.length(); i++) {

            if (s.charAt(i) == '{') {
                balance++;
            } else if (s.charAt(i) == '}') {
                balance--;

                if (balance == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}