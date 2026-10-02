class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(n,"",res, 0, 0);
        return res;
    }
    private void helper(int n, String s, List<String> res, int open, int close){

        if(s.length()==n*2){
            res.add(s);
            return;
        }

        if(open < n){
            helper(n, s+"(", res, open+1, close);
        }
        if(close < open){
            helper(n, s+")", res, open, close+1);
        }
    }
}