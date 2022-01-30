/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class itemComparator implements Comparator<Item> {
    
    @Override
    public int compare(Item i1, Item i2) {
        if((double)i1.value/i1.weight < (double)i2.value/i2.weight) {
            return 1;
        } else if ((double)i1.value/i1.weight > (double)i2.value/i2.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        //sort according to descending value per weight
        Arrays.sort(arr, new itemComparator());
        
        double maxValue = 0.0;
        int curr_weight = 0;
        
        for(int i = 0; i < n; i++) {
            
            if(curr_weight + arr[i].weight <= W) {
                maxValue += arr[i].value;
                curr_weight += arr[i].weight;
            } else {
                maxValue += ((double)arr[i].value/(double)arr[i].weight)*((double)(W-curr_weight));
                curr_weight += (double)arr[i].value/(double)arr[i].weight;
                break;
            }
        }
        return maxValue;
    }
}
