import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        // Rotate the queue to make the last added element the front
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Example usage:
 * MyStack obj = new MyStack();
 * obj.push(1);
 * obj.push(2);
 * System.out.println(obj.top());   // 2
 * System.out.println(obj.pop());   // 2
 * System.out.println(obj.empty()); // false
 */
