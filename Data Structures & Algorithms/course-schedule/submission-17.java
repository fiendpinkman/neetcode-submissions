class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> reqToComplete = new HashMap<>();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            reqToComplete.put(prerequisite[1], reqToComplete.getOrDefault(prerequisite[1], 0) + 1);
            neighbors.computeIfAbsent(prerequisite[0], a -> new ArrayList<>()).add(prerequisite[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int[] prerequisite: prerequisites) {
            if (!reqToComplete.containsKey(prerequisite[0]) && !q.contains(prerequisite[0])) {
                q.add(prerequisite[0]);
            }
        }

        while(!q.isEmpty()) {
            int parent = q.remove();
            if (!neighbors.containsKey(parent)) continue;
            for (Integer neighbor: neighbors.get(parent)) {
                reqToComplete.put(neighbor, reqToComplete.get(neighbor) - 1);
                if (reqToComplete.get(neighbor) == 0) {
                    q.add(neighbor);
                    reqToComplete.remove(neighbor);
                }
            }
        }

        return reqToComplete.size() == 0;
    }
}
