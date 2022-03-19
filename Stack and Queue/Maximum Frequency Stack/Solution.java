class FreqStack {
    List<Stack<Integer>> buckets;
    HashMap<Integer, Integer> freq_map;
    
    public FreqStack() {
        buckets = new ArrayList<Stack<Integer>>();
        freq_map = new HashMap<Integer, Integer>();
    }
    
    public void push(int val) {
        freq_map.put(val, freq_map.getOrDefault(val, 0) + 1);
        int currFreq = freq_map.get(val);
        if(currFreq-1 >= buckets.size()) {//list is 0 indexed
            buckets.add(new Stack<Integer>());
        }
        buckets.get(currFreq-1).add(val);//list is 0 indexed
    }
    
    public int pop() {
        int maxFreq = buckets.size();
        int val = buckets.get(maxFreq-1).pop();//list is 0 indexed
        if(buckets.get(maxFreq-1).size() == 0) {
            buckets.remove(maxFreq - 1);
        }
        freq_map.put(val, freq_map.get(val) - 1);
        return val;
    }
}

//ALTER

// class FreqStack {
    
//     class Value {
//         int val;
//         int freq;
//         int time;
        
//         Value(int val, int freq, int time) {
//             this.val = val;
//             this.freq = freq;
//             this.time = time;
//         }
//     }
//     class ValueComparator implements Comparator<Value> {

//         @Override
//         public int compare(Value val1, Value val2) {
//             if(val1.freq > val2.freq) {
//                 return -1;
//             } else if(val1.freq < val2.freq) {
//                 return 1;
//             } else {
//                 return val2.time - val1.time;
//             }
//         }
//     }
//     int time;
//     PriorityQueue<Value> max_freq;
//     HashMap<Integer, Integer> freq_map;
//     public FreqStack() {
//         freq_map = new HashMap<Integer, Integer>();
//         max_freq = new PriorityQueue<Value>(new ValueComparator());
//         time = 0;
//     }
    
//     public void push(int val) {
//         time++;
//         freq_map.put(val, freq_map.getOrDefault(val, 0) + 1);
//         int currFreq = freq_map.get(val);
//         max_freq.add(new Value(val, currFreq, time));
//     }
    
//     public int pop() {
//         int val = max_freq.remove().val;
//         freq_map.put(val, freq_map.get(val) - 1);
//         return val;
//     }
// }
