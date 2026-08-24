class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        ArrayList<int[]> ans = new ArrayList<>();

        for(int[] interval: intervals){

            // No Overlap
            if(ans.isEmpty() || interval[0] > ans.get(ans.size()-1)[1]){
                ans.add(new int[]{interval[0], interval[1]});
            }
            // Overlap
            else{
                int[] last = ans.get(ans.size()-1);

                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}