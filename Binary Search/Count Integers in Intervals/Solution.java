class CountIntervals {
    // Interval treemap start -> finish.
    TreeMap<Integer, Integer> s;
    int count;
    public CountIntervals() {
        s = new TreeMap<Integer, Integer>();
        count = 0;
    }
    
    public void add(int left, int right) {
        // Add interval if there is no overlapping.
        if (s.floorKey(right) == null || s.get(s.floorKey(right)) < left) {
            s.put(left, right);
            count += (right - left + 1);
        } else {
            int start = left;
            int end = right;
            
            // Remove overlapping intervals and update count.
            //find interval whose starting is lesser than curr's ending and my curr's starting is smaller than that intervals ending
            while (s.floorKey(end) != null && s.get(s.floorKey(end)) >= start) {
                int l = s.floorKey(end);
                int r = s.get(l);
                start = Math.min(start, l);
                end = Math.max(end, r);
                count -= (r - l + 1);
                s.remove(l);
            }
            // Add (start, end) to TreeMap and update count.
            s.put(start, end);
            count += (end - start + 1);
        }
    }
    
    public int count() {
        return count;
    }
}
