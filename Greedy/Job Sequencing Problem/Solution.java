class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        //how many max jobs can one person perform
        //max number of trains in one platform
        
        //sort according to profit ascending
        Arrays.sort(arr, (a,b) -> (b.profit-a.profit));
        int maxDeadline = 0;
        for(Job j : arr) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        int[] visited = new int[maxDeadline];
        Arrays.fill(visited, -1);
        //we will perform every job in decreasing order of profit i.e., max to least
        //we will perform each job on last possible day
        //in visited array, we will mark the day wherein we do the job, 
        //so that we can schedule other jobs accordingly
        //as each job takes only 1 day
        int totalProfit = 0;
        int totalJobs = 0;
        for(int i = 0; i < n; i++) {
            Job j = arr[i];
            int dayOfJob = j.deadline-1;//0 indexed array
            while(dayOfJob >= 0 && visited[dayOfJob] != -1) {
                dayOfJob--;
            }
            if(dayOfJob >= 0) {
                //perform that job
                visited[dayOfJob] = j.id;//we are marking job id on that day
                totalProfit += j.profit;
                totalJobs++;
            }
        }
        //we can iterate over visited array and ignore (-1)s to find sequence of jobs as well
        return new int[]{totalJobs, totalProfit};
        
    }
}
