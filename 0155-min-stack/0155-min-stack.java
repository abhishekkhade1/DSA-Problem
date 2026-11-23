class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        
    }
    
    public void push(int value) {
        st.push(value);

        if(minSt.isEmpty() || minSt.peek() >= value){
            minSt.push(value);
        }
        
    }
    
    public void pop() {

        int pop = st.pop();

        if(pop == minSt.peek()){
            minSt.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minSt.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */