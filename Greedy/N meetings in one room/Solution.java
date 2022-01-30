class meeting {
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComp implements Comparator<meeting> {
    
    @Override
    public int compare(meeting o1, meeting o2) {
        if(o1.end < o2.end) {
            return -1;
        } else if(o1.end > o2.end) {
            return 1;
        } else if(o1.pos < o2.pos) {
            return 1;
        } else {
            return -1;
        }
    }
}
class Solution 
{
    
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        meeting[] meetings = new meeting[n];
        for(int i = 0; i < meetings.length; i++) {
            meetings[i] = new meeting(start[i], end[i], i+1);
        }
        //sort according to ending time of meetings
        Arrays.sort(meetings, new meetingComp());
        
        ArrayList<Integer> meetingResult = new ArrayList<Integer>();
        
        //first meeting will always be performed
        meetingResult.add(meetings[0].pos);
        int curr_end = meetings[0].end;
        for(int i = 1; i < n; i++) {
            if(meetings[i].start > curr_end) {
                meetingResult.add(meetings[i].pos); 
                curr_end = meetings[i].end;
            }
        }
        //meeting result holds the meeting numbers of the doable meetings
        return meetingResult.size();
    }
}
