class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        if(n == 2) return nums;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int i = 0;
        int j = 0;

        arr1[i] = nums[0];
        arr2[j] = nums[1];

        for(int k = 2; k < n; k++){

            if(arr1[i] > arr2[j]){
                arr1[++i] = nums[k];
            }else{
                arr2[++j] = nums[k];
            }
        }
        for(int m = 0; m <= j; m++){
            arr1[++i] = arr2[m];
        }

        return arr1;
    }
}