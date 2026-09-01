class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        helper(k, n, 1, ans, partial_ans);

        return ans;
       
    }
    public void helper(int k, int tar,int i, List<List<Integer>> ans, List<Integer> partial_ans){

        if(partial_ans.size() == k){

            if(tar == 0){
                ans.add(new ArrayList(partial_ans));
            }
            return;
        } 

        for(int start = i; start<=9; start++){

            if(start > tar) return;

            partial_ans.add(start);
            helper(k, tar-start, start + 1, ans, partial_ans);
            partial_ans.remove(partial_ans.size()-1);

        }   

    }
}