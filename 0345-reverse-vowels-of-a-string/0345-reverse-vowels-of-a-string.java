class Solution {
    public String reverseVowels(String s) {

        int n = s.length();
        int i = 0;
        int j = n - 1;

        char[] arr = s.toCharArray();

        while (i < j) {

            if (!vowels(arr[i])) {
                i++;
                continue;
            }

            if (!vowels(arr[j])) {
                j--;
                continue;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }

    public boolean vowels(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }
}