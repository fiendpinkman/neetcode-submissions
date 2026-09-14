class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n-1 !=edges.length) {
            return false;
        }
        Map<Integer, List<Integer>> iMap = new HashMap<>();
        for (int[] edge:edges) {
            iMap.computeIfAbsent(edge[0], a-> new ArrayList<Integer>()).add(edge[1]);
            iMap.computeIfAbsent(edge[1], a-> new ArrayList<Integer>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int candidate = q.poll();
            if (iMap.get(candidate)!=null) {
                for(Integer i: iMap.get(candidate)) {
                    if (!visited.contains(i)) {
                        visited.add(i);
                        q.add(i);
                    }
                }
            }
        }
        System.out.println(visited);
        return visited.size() == n;
    }
}
