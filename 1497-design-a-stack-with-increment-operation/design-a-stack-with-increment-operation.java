class CustomStack {
    int[] stack;
    int[] inc;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if (top + 1 < stack.length) {
            stack[++top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) return -1;
        int res = stack[top] + inc[top];
        if (top > 0) {
            inc[top - 1] += inc[top]; // pass increment to below element
        }
        inc[top] = 0; // reset increment for this position
        top--;
        return res;
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k, top + 1) - 1;
        if (idx >= 0) {
            inc[idx] += val;
        }
    }
}
