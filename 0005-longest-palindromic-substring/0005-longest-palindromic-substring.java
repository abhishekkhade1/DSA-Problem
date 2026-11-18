// TC:o(n^3)

// class Solution {
//     public String longestPalindrome(String s) {
//         int maxLen = 0;
//         int start = 0;

//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                 if(checkPalindrome(s,i,j)){
//                     int len = j-i+1;
//                     if(len>maxLen){
//                         maxLen = len;
//                         start = i;
//                     }
                    
//                 }
//             }
//         }
//         return s.substring(start,start+maxLen);
//     }
//     public boolean checkPalindrome( String s,int i,int j){

//         while(i<j){
//             if(s.charAt(i)!=s.charAt(j)){
//                 return false;
//             }i++;
//             j--;
//         }
//         return true;
//     }
// }

class Solution {
     int start = 0;
     int length = 0;
    public String longestPalindrome(String s) {

        // if(s.length() == 1) return s;
        for(int i=0;i<s.length();i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }

       return s.substring(start,start+length);
    }
    private void expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
            int len = right-left+1;

            if(len>length){
                length = len;
                start =left;
            }
            left--;
            right++;
        }
    }
}