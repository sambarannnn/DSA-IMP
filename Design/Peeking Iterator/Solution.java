// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer peek;
    private boolean hasPeeked;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peek = null;
        hasPeeked = false;
        this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(hasPeeked) {
            return peek;
        } else {
            peek = iterator.next();
            hasPeeked = true;
            return peek;
        }
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasPeeked) {
            Integer x = peek;
            peek = null;
            hasPeeked = false;
            return x;
        } else {
            return iterator.next();
        }
	}
	
	@Override
	public boolean hasNext() {
	    if(hasPeeked) {
            return true;
        } else {
            return iterator.hasNext();
        }
	}
}
