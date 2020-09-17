class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int num) {
        visited[num] = true;
        
        for (int i = 0; i < computers.length; ++i) {
            if (num != i && !visited[i] && computers[num][i] == 1) {
                dfs(computers, visited, i);
            } 
        }
    }
}