class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        helper(candidates, target, 0, ans, partial_ans);

        return ans;

    }
    public void helper(int[] arr, int tar, int i, List<List<Integer>> ans, List<Integer> partial_ans){

    
        if(tar==0){
            ans.add(new ArrayList(partial_ans));
            return;
        }

        if(i == arr.length) return;

        if(tar >= arr[i]){
            partial_ans.add(arr[i]);
            helper(arr, tar-arr[i], i+1, ans, partial_ans);
            partial_ans.remove(partial_ans.size()-1);
        }
         while(i+1 < arr.length && arr[i] == arr[i+1]){
            i++;
        }

        helper(arr, tar, i+1, ans, partial_ans);

       

    }
}