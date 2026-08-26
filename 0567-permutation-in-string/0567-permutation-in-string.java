class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        int[] freqS1 = new int[26];
        int[] window = new int[26];

        for(char ch: s1.toCharArray()){
            freqS1[ch-'a']++;
        }

        // first window
        int n = s1.length();
        for(int i=0; i<n; i++){

            char c = s2.charAt(i);

            window[c -'a']++;
        }

        if(Arrays.equals(freqS1, window)) return true;

        // slide window
        for(int k = n; k < s2.length(); k++){
            // add character
            window[s2.charAt(k) -'a']++;

            // remove
            window[s2.charAt(k-n)-'a']--;

            if(Arrays.equals(freqS1, window)) return true;
        }
        return false;

        
    }
    
}