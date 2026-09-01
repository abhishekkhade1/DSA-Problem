class Solution {
    public int minimumDeletions(int[] nums) {
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        int n = nums.length;

        int maxIdx = 0;
        int minIdx = 0;

        for(int i=1; i<n; i++){

            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }

            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
        }

        // left smaller index
        // rigth larger index;

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int fromFront = right +1;
        int fromBack = n - left;
        int fromBoth = (left +1) + (n- right);

        return Math.min(fromFront,Math.min( fromBack, fromBoth));

    }
}