class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> iMap = new HashMap<>();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            // fix 1: prerequisite[1] -> prerequisite[0], indegree of prerequisite[0]
            iMap.put(prerequisite[0], iMap.getOrDefault(prerequisite[0], 0) + 1);
            List<Integer> temp = neighbors.getOrDefault(prerequisite[1], new ArrayList<Integer>());
            temp.add(prerequisite[0]);
            neighbors.put(prerequisite[1], temp);
        }

        // fix 2: seed with every course whose indegree is 0, not by scanning edges
        for (int i = 0; i < numCourses; i++) {
            if (iMap.getOrDefault(i, 0) == 0) {
                q.add(i);
            }
        }

        int processed = 0;
        while (!q.isEmpty()) {
            int parent = (int) q.poll();
            processed++; // fix 3: track how many we actually finish
            List<Integer> nbrs = neighbors.get(parent);
            if (nbrs == null) continue; // parent may have no outgoing edges
            for (Integer neighbor : nbrs) {
                iMap.put(neighbor, iMap.get(neighbor) - 1);
                if (iMap.get(neighbor) == 0) {
                    q.add(neighbor);
                    iMap.remove(neighbor);
                }
            }
        }

        return processed == numCourses; // fix 3 cont'd
    }
}