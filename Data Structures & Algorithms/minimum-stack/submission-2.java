class MinStack {
    private Stack<Long> s;
    private long min; 

    public MinStack() {
        this.s = new Stack<>();
    }
    
    public void push(int val) {
        if (this.s.isEmpty()) {
            min = val;
            this.s.push(0L);
        } else {
            this.s.push(val- min);
            if (min>val) min = val;
        }
    }
    
    public void pop() {
        if (this.s.isEmpty())   return;
        long val = this.s.pop();
        if (val < 0) min = min - val;
    }
    
    public int top() {
        long top = this.s.peek();
        if (top < 0) {
            return (int) min;
        } else {
            return (int) (min + top);
        }
    }
    
    public int getMin() {
        return (int) this.min;
    }
}
