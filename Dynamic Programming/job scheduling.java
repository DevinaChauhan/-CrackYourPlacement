import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });

        // Find the maximum deadline to determine the size of the slot array
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Initialize slots to keep track of free slots
        boolean[] slot = new boolean[maxDeadline + 1];
        int countJobs = 0;
        int maxProfit = 0;

        // Schedule jobs
        for (Job job : arr) {
            // Try to find a free slot for the job
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true; // Mark this slot as occupied
                    countJobs++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, maxProfit};
    }
}
