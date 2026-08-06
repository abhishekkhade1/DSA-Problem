class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> curr = new ArrayList<>();
        helper(s,0,0,curr);
        return ans;
    }
    private void helper(String s, int i , int parts, List<String> curr){
        int n = s.length();

        if(i==n && parts == 4){
            ans.add(String.join(".", curr));
            return;
        }

        if(i == n || parts == 4) return;

        for(int len = 1; len <= 3 && len+i <= n; len++ ){

            String part = s.substring(i,i+len);
            
            // No leading zero
            if(part.length() > 1 && part.charAt(0) == '0' ) break;

            // chaeck range 0-255
            int val = Integer.parseInt(part);
            if(val <= 255){
                curr.add(part);
                helper(s, i+len, parts+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}