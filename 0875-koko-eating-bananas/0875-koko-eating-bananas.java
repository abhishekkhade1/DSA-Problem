class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int ans = -1;

        for(int num:piles){
            high = Math.max(high, num);
        }

        while(low <= high){

            int mid = low + (high - low)/2;

            if(check(piles, h, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

        
    }

    public boolean check(int[] piles, int h, int k) { // k is speedof eating bannana
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    
}