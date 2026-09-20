class Solution {

    boolean flag = true;

    public boolean isBipartite(int[][] graph) {
        // -1 = not visited, 0 = blue colour, 1 = red colour
        int n = graph.length;

        int [] colour = new int[n];
        Arrays.fill(colour, -1);

        for(int i = 0; i<n; i++){

            if(colour[i] == -1){
                colour[i] = 0;
                dfs(graph, i, colour);
                
            }
        }
        return flag;
 
    }
    public void dfs(int[][] graph, int start, int[] colour){

        for(int child:graph[start]){

            if(colour[child]== -1){
                if(colour[start] == 0){
                    colour[child] = 2;
                }
                else{
                    colour[child] = 0;
                }
                dfs(graph, child, colour);
            }
            else if(colour[child] == colour[start]){
                flag = false;
                return;
            }
        }

    }
}