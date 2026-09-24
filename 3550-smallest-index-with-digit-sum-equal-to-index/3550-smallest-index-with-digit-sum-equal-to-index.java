class Solution {
    public int smallestIndex(int[] nums) {
        
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int sum = sum(nums[i]);
            if(i == sum){
                if(sum < min){
                    min = i;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public int sum(int num){
        int sum = 0;

        while(num != 0){
            sum += num % 10;
            num = num/10;
        }
        return sum;

    }
}