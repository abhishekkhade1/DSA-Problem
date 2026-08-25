class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        List<Integer>partial_ans = new ArrayList();
         combinationSumHelper(0,partial_ans,candidates,target,ans);
         return ans;

    }
    public void combinationSumHelper(int i,List<Integer>partial_ans,int[] arr,int target,List<List<Integer>> ans){
            if(i==arr.length) return;

            if(target == 0){
                ans.add(new ArrayList(partial_ans));
                return;
            }

            if(target >= arr[i] ){
                partial_ans.add(arr[i]);
                combinationSumHelper(i, partial_ans, arr, target-arr[i], ans);
                partial_ans.remove(partial_ans.size()-1);
            }

             combinationSumHelper(i+1, partial_ans, arr, target, ans);
         
    }
}