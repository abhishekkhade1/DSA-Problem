class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        helper(nums, ans, partial_ans, used);
        return ans;

    }

    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> partial_ans, boolean[] used){

        if(partial_ans.size() == nums.length){
            ans.add(new ArrayList(partial_ans));
            return;
        }

        for(int i=0; i<nums.length; i++ ){

            if(!used[i]){
            
                partial_ans.add(nums[i]);
                used[i] = true;
                helper(nums, ans, partial_ans, used);

                used[i] = false;
                partial_ans.remove(partial_ans.size()-1);
            }
        }

    }
}