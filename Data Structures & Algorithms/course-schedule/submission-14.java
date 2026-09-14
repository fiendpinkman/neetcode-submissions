class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> iMap = new HashMap<>();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int[] prerequisite: prerequisites) {
            iMap.put(prerequisite[1], iMap.getOrDefault(prerequisite[1], 0) + 1);
            List<Integer> temp = neighbors.getOrDefault(prerequisite[0], new ArrayList<Integer>());
            temp.add(prerequisite[1]);
            neighbors.put(prerequisite[0], temp);
        }
        
        Set<Integer> seeded = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            if (iMap.get(prerequisite[0]) == null && seeded.add(prerequisite[0])) {
                q.add(prerequisite[0]);
            }
        }
    
        while(!q.isEmpty()) {
            int parent = (int) q.poll();
            System.out.println("Queue :" + parent);
            List<Integer> temp = neighbors.get(parent);
            if (temp!=null) {
                for (Integer neighbor: temp) {
                    iMap.put(neighbor, iMap.get(neighbor)-1);
                    if (iMap.get(neighbor)==0) {
                        q.add(neighbor);
                        iMap.remove(neighbor);
                    }
                }
            }
        }
        
        return iMap.size()==0;
    }
}