class MyStack {
    //1 queue, O(N) INSERT O(1) DELETE
    int top;
    Queue<Integer> queue;
    boolean isEmpty;
    public MyStack() {
        top = -1;
        queue = new LinkedList<Integer>();
        isEmpty = true;
    }
    
    public void push(int x) {
        top = x;
        queue.add(x);
        int size = queue.size();
        while(size-- > 1) {
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
        if(queue.isEmpty())
             return true;
         return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// class MyStack {
//     //1 queue, O(1) INSERT, O(N) DELETE
//     int top;
//     Queue<Integer> queue;
//     boolean isEmpty;
//     public MyStack() {
//         top = -1;
//         queue = new LinkedList<Integer>();
//         isEmpty = true;
//     }
    
//     public void push(int x) {
//         top = x;
//         queue.add(x);
//     }
    
//     public int pop() {
//         int size = queue.size();
//         while(size-- > 1) {
//             top = queue.remove();
//             queue.add(top);
//         }
//         return queue.remove();
//     }
    
//     public int top() {
//         return top;
//     }
    
//     public boolean empty() {
//         if(queue.isEmpty())
//              return true;
//          return false;
//     }
// }

// /**
//  * Your MyStack object will be instantiated and called as such:
//  * MyStack obj = new MyStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * boolean param_4 = obj.empty();
//  */

// class MyStack {
//     //2 queues, O(1) INSERT & O(N) POP
//     int top;
//     Queue<Integer> queue1;
//     Queue<Integer> queue2;
//     boolean isEmpty;
//     public MyStack() {
//         top = -1;
//         queue1 = new LinkedList<Integer>();
//         queue2 = new LinkedList<Integer>();
//         isEmpty = true;
//     }
    
//     public void push(int x) {
//         top = x;
//         queue1.add(x);
//     }
    
//     public int pop() {
//         while(queue1.size() > 1) {
//             queue2.add(queue1.remove());
//         }
//         int x = queue1.remove();
//         if(queue2.size() > 0) {
//             while(queue2.size() > 1) {
//                 queue1.add(queue2.remove());
//             }
//             top = queue2.remove();
//             queue1.add(top);
//         } else {
//             top = -1;
//         }
//         return x;
//     }
    
//     public int top() {
//         return top;
//     }
    
//     public boolean empty() {
//         if(queue1.isEmpty() && queue2.isEmpty())
//              return true;
//          return false;
//     }
// }

// /**
//  * Your MyStack object will be instantiated and called as such:
//  * MyStack obj = new MyStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * boolean param_4 = obj.empty();
//  */
