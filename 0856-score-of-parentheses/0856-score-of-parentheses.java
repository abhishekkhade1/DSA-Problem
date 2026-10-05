class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(char ch : s.toCharArray()){

            if(ch == '('){
                st.push(0);
            }
            else{

                int curr = st.pop();

                if(curr == 0){
                    curr = 1;
                }else{

                    curr = 2 * curr;
                }

                st.push(curr + st.pop());
            }
        
        }
        return st.pop();
    }
}