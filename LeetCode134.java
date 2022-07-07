class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] sum = new int[gas.length];
        int total = 0;
        Integer running = null;
        Integer pos = null;
        for(int i = 0; i < gas.length; i ++){
            sum[i] = gas[i] - cost[i];
            total += sum[i];
            if(running == null){
                if(sum[i] >= 0){
                    running = sum[i];
                    pos = i;
                }
            } else {
                if(sum[i] + running < 0){
                    running = null;
                } else
                    running += sum[i];
            }
        }
        if(total < 0)
            return -1;
        return pos;
    }
}
