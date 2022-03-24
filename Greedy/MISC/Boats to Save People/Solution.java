class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        //pair the heaviest person with lightest person
        //if no possible pair for heavy person, give him solo boat
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                boats++;
                i++;
                j--;
            } else {
                boats++;
                j--;
            }
        }
        return boats;
    }
}
