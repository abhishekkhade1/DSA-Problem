class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first_pos = firstPosition(nums, target);
        int last_pos = lastPosition(nums, target);

        return new int[]{first_pos , last_pos};
        
    }
    private int firstPosition(int[] nums, int tar){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == tar){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid] < tar){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
           
        } return ans;
    }
    private int lastPosition(int[] nums, int tar){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == tar){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid] < tar){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }return ans;
    }
}