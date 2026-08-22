class Solution {
    public boolean checkDivisibility(int n) {
        
        int product = 1;
        int sum =0;
        int temp = n;

        while(temp > 0){
            int last = temp % 10;
            product*=last;
            sum+=last;
            temp=temp/10;
        }
        int total = sum+product;
        return n % total == 0;
    }
}