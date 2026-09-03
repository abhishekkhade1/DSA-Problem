class Solution {
    public boolean uniformArray(int[] nums) {
        int smallOdd = Integer.MAX_VALUE;

        for(int num:nums){
            if(num%2 == 1)
                smallOdd = Math.min(smallOdd, num);
        }

        // all nums are even
        if(smallOdd == Integer.MAX_VALUE){
            return true;
        }

        // can we make even number to odd
        for(int num: nums){

            if(num % 2 == 0 && num <= smallOdd){
                return false;
            }
        }
        return true;
    }
}