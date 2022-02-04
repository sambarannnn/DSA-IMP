public class Solution {
    public int books(int[] A, int B) {
        if (B > A.length) return -1;
        //min no of (max alloted)pages will be if all books have equal pages and we have students B = no of books
        //everyone will get just one book with same no of pages
        //so max for all will be same
        //and this is only possible permutation so min of maxes will be this itself
        int low = A[0];

        //max no of (max alloted)pages will be if there is only one student
        //all the books will be alloted to him
        int high = 0;
        for(int pages : A) {
            low = Math.min(low, pages);
            high += pages;
        }
        //we need to find minimum possible max alloted pages
        //find leftmost viable Solution
        int res = 0;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(isViable(A, B, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        //low is pointing at min possible viable soln
        return low;
    }
    static boolean isViable(int[] A, int students, int max_pages) {
        int cnt_students = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.length; i++) {
            if (sumAllocated + A[i] > max_pages) {
                cnt_students++;
                sumAllocated = A[i];

                if (sumAllocated > max_pages) 
                    return false;//if current book has more pages than max pages
            } else {
                sumAllocated += A[i];
            }
        }
        if (cnt_students < students) 
            return true;
        return false;
    }
}
