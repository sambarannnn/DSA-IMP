/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//LAZY IMPLEMENTATION
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;//use stack so that we can traverse internal lists as we go and add their integers to the top
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        addAll(nestedList);
    }
    public void addAll(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1; i>= 0; i--) {//push in reverse order
            stack.push(nestedList.get(i));
        }
    }
    public void process() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger curr = stack.pop();
            addAll(curr.getList());
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();//already prepared current list, just pop
    }

    @Override
    public boolean hasNext() {//hasnext is always called before next so process here
        process();//prepeare the current nestedInteger (breakDown any internal lists)
        return !stack.isEmpty();
    }
}
// public class SLOWERNestedIterator implements Iterator<Integer> {

//     private Queue<Integer> queue;
//     public SLOWERNestedIterator(List<NestedInteger> nestedList) {
//         queue = new LinkedList<Integer>();
//         flatten(nestedList, queue);
//     }
//     public void flatten(List<NestedInteger> nestedList, Queue<Integer> queue) {
//         for(NestedInteger curr : nestedList) {
//             if(curr.isInteger()) {
//                 queue.add(curr.getInteger());
//             } else {
//                 flatten(curr.getList(), queue);
//             }
//         }
//     }

//     @Override
//     public Integer next() {
//         return queue.remove();
//     }

//     @Override
//     public boolean hasNext() {
//         return !queue.isEmpty();
//     }
// }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
