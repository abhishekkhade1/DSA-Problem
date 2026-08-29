class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int current = 1;

            for(int num:target){
                while(current < num){
                    ans.add("Push");
                    ans.add("Pop");
                    current++;
                } 
                
                    ans.add("Push");
                    current++;
                
            }           
        
        return ans;  
    }
}