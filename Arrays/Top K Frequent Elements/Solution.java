class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //O(N) using bucket sort
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max_freq = Integer.MIN_VALUE;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            max_freq = Math.max(max_freq, map.get(num));
        }
        Stack<Integer>[] buckets = new Stack[max_freq+1];
        
        for(int num : map.keySet()) {
            int freq = map.get(num);
            if(buckets[freq] == null) {
                buckets[freq] = new Stack<Integer>();
            }
            buckets[freq].add(num);
        }
        
        int[] res = new int[k];
        //travel from right to left of buckets in decreasing order of frequencies
        int currFreq = buckets.length - 1;
        while(k > 0) {
            while(buckets[currFreq] == null || buckets[currFreq].size() == 0) {
                currFreq--;
            }
            res[--k] = buckets[currFreq].pop();
        }
        return res;
    }
//     public int[] topKFrequent(int[] nums, int k) {
//         //O(NlogK)
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }
//         //keeping only top k elements, least frequent out of top k is at root
//         PriorityQueue<int[]> minheap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        
//         for(int num : map.keySet()) {
//             minheap.add(new int[]{num, map.get(num)});
//             if(minheap.size() > k) {
//                 minheap.remove();
//             }
//         }
//         int[] res = new int[k];
//         while(k > 0) {
//             res[--k] = minheap.remove()[0];
//         }
//         return res;
//     }
}
