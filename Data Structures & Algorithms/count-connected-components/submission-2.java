class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> iMap = new HashMap<>();
        for (int[] edge:edges) {
            iMap.computeIfAbsent(edge[0], a-> new ArrayList<Integer>()).add(edge[1]);
            iMap.computeIfAbsent(edge[1], a-> new ArrayList<Integer>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int component = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                component++;
                visited[i] = true;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int candidate = q.poll();
                    List<Integer> neighbours = iMap.get(candidate);
                    if (neighbours != null) {
                        for (int neighbour:neighbours) {
                            if (!visited[neighbour]) {
                                visited[neighbour] = true;
                                q.add(neighbour);
                            }
                        }
                    }
                }
            }
        }

        return component;
    }
}
