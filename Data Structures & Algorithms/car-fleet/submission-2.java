class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        // create one array
        for (int i =0; i<position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // sort array
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> s = new Stack<>();
        for(int[] pair: pairs) {
            int p = pair[0];
            int sp = pair[1];
            double timeTaken = (double) (target-p)/sp;
            s.push(timeTaken);
            if(s.size()>=2) {
                double first = s.peek();
                double second = s.get(s.size()-2);
                if(first<=second) {
                    s.pop();
                }
            }
        }
        return s.size();
    }
}
