class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = 0;
        for(int n:bloomDay){
            high = Math.max(high, n);
        }

        int ans = -1;
        while(low <= high){
            
            int mid = low + (high - low)/2;

            if(check(bloomDay, m, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }
    public boolean check(int[] bloomDay, int m, int k, int minDays) {

        int currBouquets = 0;
        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= minDays) {

                flowers++;

                if (flowers == k) {
                    currBouquets++;
                    flowers = 0;
                }

            } else {
                flowers = 0;
            }
        }

        return currBouquets >= m;
}
}