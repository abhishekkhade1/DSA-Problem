class StockSpanner {
    class Pair{
        int val;
        int idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    Stack<Pair> st;
    int idx;

    public StockSpanner() {
        st = new Stack();
        idx = -1;
    }
    
    public int next(int price) {
        idx = idx+1;

        while(!st.isEmpty() && st.peek().val <= price){
            st.pop();
        }

        int span=0;
        if(st.isEmpty()){
            span = idx+1;
        }else{
            span += idx - st.peek().idx;
        }

        st.push(new Pair(price, idx));
        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */