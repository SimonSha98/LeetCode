class Job {
    int start;
    int end;
    int profit;
    public Job(int startTime, int endTime, int profit){
        this.start = startTime;
        this.end = endTime;
        this.profit = profit;
    }
}
class Solution {
    Integer[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {// max profit at time i
        List<Job> job = new ArrayList();
        memo = new Integer[startTime.length+1];
        for(int i = 0; i < endTime.length; i ++){
            job.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(job, (Job a, Job b) -> a.end - b.end);
        memo[0] = 0;
        for(int i = 1; i <= endTime.length; i ++){
            memo[i] = Math.max(memo[i-1], memo[find(job, job.get(i-1).start)] + job.get(i-1).profit);
        }
        return memo[endTime.length];
    }
    private int find(List<Job> job, int start){
        int l = 0, r = job.size() - 1;
        Integer index = null;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(job.get(mid).end <= start){
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index == null ? 0 : index + 1;
    }
}
