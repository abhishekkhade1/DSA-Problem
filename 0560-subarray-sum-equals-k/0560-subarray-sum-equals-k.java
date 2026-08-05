class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int x:nums){

            prefixSum+=x;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}