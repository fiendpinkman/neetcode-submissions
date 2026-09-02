class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stackArr = new Stack<>();
        for (int i = 0; i<temperatures.length; i++) {
            if(stackArr.isEmpty()) {
                stackArr.push(new int[]{i,temperatures[i]});
            } else {
                while (!stackArr.isEmpty() && temperatures[i]>stackArr.peek()[1]) {
                    int[] pop = stackArr.pop();
                    int index = pop[0];
                    int noDay = i - index;
                    res[index] = noDay;
                }
                stackArr.push(new int[]{i,temperatures[i]});
            }
        }
        return res;
    }
}
