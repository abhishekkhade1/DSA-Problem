class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums, 0, partial_ans, ans);

        return ans;
    }

    public void helper(int[] nums,int i, List<Integer> partial_ans, List<List<Integer>> ans){

        if(i==nums.length){
            ans.add(new ArrayList(partial_ans));
            return;
        }

        partial_ans.add(nums[i]);
        helper(nums, i+1, partial_ans, ans);
        partial_ans.remove(partial_ans.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;

        helper(nums, i+1, partial_ans, ans);
    }
}