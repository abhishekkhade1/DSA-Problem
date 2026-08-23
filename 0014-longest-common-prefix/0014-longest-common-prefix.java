class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            boolean flag = true;
            
            for(int j=0; j<strs.length; j++){

                if(strs[j].length() >= i+1 && strs[j].charAt(i)== ch ){
                    continue;

                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
             ans.append(ch);
            }else{
                break;
            }
        }
        return ans.toString();
    
        
    }
}