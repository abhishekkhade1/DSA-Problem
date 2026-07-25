class Solution {
    public int trap(int[] height) {
    
    int n = height.length;


    // int leftmax[] = new int[n];
    // leftmax[0] = height[0];
    // for (int i = 1; i < n; i++) {
    //     leftmax[i] = Math.max(height[i], leftmax[i - 1]);
    // }
    // int rightmax[] = new int[n];
    // rightmax[n - 1] = height[n - 1];
    // for (int i = n - 2; i >= 0; i--) {
    //     rightmax[i] = Math.max(height[i], rightmax[i +1]);
    // }

    // int trappedRainwater = 0;
    // for (int i = 0; i < n; i++) {
    //     int waterLevel = Math.min(leftmax[i], rightmax[i]);
    //     trappedRainwater += waterLevel - height[i];
    // }

    // return trappedRainwater;

    int i = 0;
    int j = n - 1;
    int Lmax = 0;
    int Rmax = 0;
    int water = 0;

    while (i <= j) {
        if (Lmax <= Rmax) {
            water += Math.max(Lmax - height[i], 0);
            Lmax = Math.max(Lmax, height[i]);
            i++;
        } else {
            water += Math.max(Rmax - height[j], 0);
            Rmax = Math.max(Rmax, height[j]);
            j--;
        }
    }

    return water;
    }
    
    

}
    