class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        int ans = -1;

        for(int num:nums){
            high = Math.max(high, num);
        }

        while(low <= high){

            int mid = low + (high - low)/2;

            if(possible(nums, maxOperations, mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;

            }
        }
        return ans;
        
    }
    public boolean possible(int[] nums, int maxOperations, int limit){
        int operation = 0;

        for(int num:nums){
            operation += (num-1)/limit;

            if(operation > maxOperations) 
             return false;
        }
        return true;
    }
}