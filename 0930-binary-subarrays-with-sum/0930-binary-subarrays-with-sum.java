class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int x:nums){

            prefixSum+=x;

            if(map.containsKey(prefixSum - goal)){
                count += map.get(prefixSum - goal);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}